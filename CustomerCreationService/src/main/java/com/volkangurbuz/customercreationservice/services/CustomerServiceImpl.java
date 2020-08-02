package com.volkangurbuz.customercreationservice.services;

import com.volkangurbuz.customercreationservice.domain.Customer;
import com.volkangurbuz.customercreationservice.repositories.CustomerRepository;
import com.volkangurbuz.customercreationservice.utilities.Messages;
import com.volkangurbuz.customercreationservice.utilities.PasswordUtils;
import com.volkangurbuz.customercreationservice.utilities.results.Result;
import com.volkangurbuz.customercreationservice.utilities.results.SuccessResult;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;

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
}
