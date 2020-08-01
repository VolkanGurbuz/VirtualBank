package com.volkangurbuz.customercreationservice.services;

import com.volkangurbuz.customercreationservice.domain.Customer;
import com.volkangurbuz.customercreationservice.utilities.results.Result;

import java.util.List;

public interface CustomerService {

  Result addCustomer(Customer customer);

  List<Customer> getCustomers();
}
