package com.volkangurbuz.customercreationservice.repositories;

import com.volkangurbuz.customercreationservice.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
  @Query("{ 'name': ?0 }")
  List<Customer> findCustomerByName(String name);
}
