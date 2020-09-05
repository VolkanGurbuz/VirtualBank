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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;
  @Autowired private MongoTemplate mongoTemplate;

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

    List<Customer> optionalCustomerList = customerRepository.findCustomerByName(firstName);
    logger.info("listsie" + optionalCustomerList.size());
    if (optionalCustomerList.size() == 0) {
      throw new NotFoundException("First name did not find " + firstName);
    }

    return customerRepository.findCustomerByName(firstName);
  }

  @Override
  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public Customer getCustomerById(ObjectId id) {
    Optional<Customer> customerOptional = customerRepository.findCustomerById(id);
    if (!customerOptional.isPresent()) {
      throw new NotFoundException("Customer Not Found: " + id);
    }
    return customerOptional.get();
  }

  @Override
  public void deleteById(ObjectId id) {
    customerRepository.deleteById(id);
  }

  @Override
  public void updateCustomer(Customer customer) {

    Query select = Query.query(Criteria.where("_id").is(customer.getId()));
    logger.info("info " + customer.getId() + " sele " + select.isSorted());
    Update update = new Update();
    update.set("name", customer.getName());

    mongoTemplate.findAndModify(select, update, Customer.class);
  }
}
