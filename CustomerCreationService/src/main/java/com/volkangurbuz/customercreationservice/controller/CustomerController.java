package com.volkangurbuz.customercreationservice.controller;

import com.volkangurbuz.customercreationservice.domain.Customer;
import com.volkangurbuz.customercreationservice.services.CustomerService;
import com.volkangurbuz.customercreationservice.utilities.Messages;
import com.volkangurbuz.customercreationservice.utilities.results.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping("/customers/register")
  @ResponseStatus(HttpStatus.CREATED)
  public String greetingSubmit(@ModelAttribute Customer customer, Model model) {
    Result result = customerService.addCustomer(customer);
    String resultMessage = result.getMessage();
    model.addAttribute("resultmessage", resultMessage);
    return "welcome";
  }

  @GetMapping("/customers/register")
  public String Add(@ModelAttribute Customer customer, Model model) {
    model.addAttribute("customer", customer);
    return "register";
  }
}
