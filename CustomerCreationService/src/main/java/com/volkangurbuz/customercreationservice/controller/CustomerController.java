package com.volkangurbuz.customercreationservice.controller;

import com.volkangurbuz.customercreationservice.domain.Customer;
import com.volkangurbuz.customercreationservice.exceptions.NotFoundException;
import com.volkangurbuz.customercreationservice.services.CustomerService;
import com.volkangurbuz.customercreationservice.services.CustomerServiceImpl;
import com.volkangurbuz.customercreationservice.utilities.results.Result;
import groovy.util.logging.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/api")
public class CustomerController {

  private final CustomerService customerService;
  Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  private static final String CUSTOMERFORM_URL = "redirect:/api/searchcustomerbyname";

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
    return CUSTOMERFORM_URL;
  }

  @GetMapping("/customer/{id}/update")
  public String showUpdateUpdate(@PathVariable ObjectId id, Model model) {
    model.addAttribute("customer", customerService.getCustomerById(id));
    return "customer/updatecustomer";
  }

  @PostMapping("/customers/update")
  public String updateCustomer(@ModelAttribute Customer customer) {
    customerService.updateCustomer(customer);
    return CUSTOMERFORM_URL;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @GetMapping("/actions/withdraw")
  public String withDraw(@ModelAttribute Customer customer, Model model, double withDraw) {
    customerService.withDraw(customer, withDraw);
    model.addAttribute("balance", customer.getBalance());
    return "withdraw";
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException.class)
  public ModelAndView handleNotFound(Exception exception) {

    logger.error("handling not found exception");
    logger.error(exception.getMessage());

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("exception", exception);

    modelAndView.setViewName("404error");
    return modelAndView;
  }
}
