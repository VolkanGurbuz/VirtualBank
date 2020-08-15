package com.volkangurbuz.customercreationservice.services;

import com.volkangurbuz.customercreationservice.domain.Customer;
import com.volkangurbuz.customercreationservice.exceptions.NotFoundException;
import com.volkangurbuz.customercreationservice.repositories.CustomerRepository;
import com.volkangurbuz.customercreationservice.utilities.Messages;
import com.volkangurbuz.customercreationservice.utilities.PasswordUtils;
import com.volkangurbuz.customercreationservice.utilities.results.Result;
import com.volkangurbuz.customercreationservice.utilities.results.SuccessResult;
import groovy.util.logging.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;

  Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

  public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public Result addCustomer(Customer customer) {
    String salt = PasswordUtils.getSalt(30);
    customer.setPassword(PasswordUtils.generateSecurePassword(customer.getPassword(), salt));
    customerRepository.save(customer);
    return new SuccessResult(true, Messages.CustomerAdded);
  }

  @Override
  public List<Customer> findByName(String firstName) {
    return customerRepository.findCustomerByName(firstName);
  }

  @Override
  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public Customer getCustomerById(ObjectId id) {
    logger.info("hey ");
    Optional<Customer> customerOptional = customerRepository.findCustomerById(id);
    if (!customerOptional.isPresent()) {
      throw new NotFoundException("Customer Not Found: " + id);
    }
    return customerOptional.get();
  }
}
