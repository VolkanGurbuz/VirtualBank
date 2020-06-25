package com.volkangurbuz.customercreationservice;

import com.volkangurbuz.customercreationservice.repositories.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerCreationServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerCreationServiceApplication.class, args);
  }
}
