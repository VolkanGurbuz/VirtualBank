package com.volkangurbuz.customercreationservice.repositories;

import com.volkangurbuz.customercreationservice.domain.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
  @Query("{ 'name': ?0 }")
  List<Customer> findCustomerByName(String name);

  Optional<Customer> findCustomerById(ObjectId objectId);
}
