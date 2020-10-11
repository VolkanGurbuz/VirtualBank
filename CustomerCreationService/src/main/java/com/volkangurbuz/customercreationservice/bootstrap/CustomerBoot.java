package com.volkangurbuz.customercreationservice.bootstrap;

import com.volkangurbuz.customercreationservice.domain.Customer;
import com.volkangurbuz.customercreationservice.repositories.CustomerRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomerBoot implements ApplicationListener<ContextRefreshedEvent> {

  private final CustomerRepository customerRepository;

  public CustomerBoot(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    String name = "volkan";

    System.out.println("size:" + customerRepository.findCustomerByName("volkan").size());
    System.out.println("size:" + customerRepository.findAll().size());
  }
}
