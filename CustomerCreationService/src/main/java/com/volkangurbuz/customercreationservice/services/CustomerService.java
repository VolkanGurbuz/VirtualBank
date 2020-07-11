package com.volkangurbuz.customercreationservice.services;

import com.volkangurbuz.customercreationservice.domain.Customer;
import com.volkangurbuz.customercreationservice.utilities.results.Result;

public interface CustomerService {

  Result addCustomer(Customer customer);
}
