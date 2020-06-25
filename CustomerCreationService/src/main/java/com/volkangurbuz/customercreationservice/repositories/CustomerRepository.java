package com.volkangurbuz.customercreationservice.repositories;

import com.volkangurbuz.customercreationservice.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {}
