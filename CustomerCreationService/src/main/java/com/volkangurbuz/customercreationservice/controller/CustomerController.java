package com.volkangurbuz.customercreationservice.controller;

import com.volkangurbuz.customercreationservice.domain.Customer;
import com.volkangurbuz.customercreationservice.services.CustomerService;
import com.volkangurbuz.customercreationservice.utilities.results.Result;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
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

  @ResponseStatus(HttpStatus.CREATED)
  @GetMapping("/customers/register")
  public String Add(@ModelAttribute Customer customer, Model model) {
    model.addAttribute("customer", customer);
    return "register";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/customers")
  public String customers(Model model) {
    model.addAttribute("customers", customerService.getCustomers());
    return "customers";
  }

  @GetMapping("/searchcustomerbyname")
  public String findCustomersByName(
      @RequestParam(value = "customers", required = false) String name, Model model) {
    model.addAttribute("customers", customerService.findByName(name));
    return "search";
  }

  @GetMapping("/customer/{id}/show")
  public String showById(@PathVariable ObjectId id, Model model) {
    model.addAttribute("customer", customerService.getCustomerById(id));
    return "customer/showcustomer";
  }

  @GetMapping("/customer/{id}/delete")
  public String deleteById(@PathVariable ObjectId id) {
    customerService.deleteById(id);
    return "redirect:/api/searchcustomerbyname";
  }
}
