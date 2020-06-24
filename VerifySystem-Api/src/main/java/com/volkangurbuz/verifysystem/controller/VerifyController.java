package com.volkangurbuz.verifysystem.controller;

import com.volkangurbuz.verifysystem.domain.Person;
import com.volkangurbuz.verifysystem.services.VerifyService;
import com.volkangurbuz.verifysystem.utilities.results.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class VerifyController {

  private final VerifyService verifyService;

  public VerifyController(VerifyService verifyService) {
    this.verifyService = verifyService;
  }

  @GetMapping("/verify")
  public String verifyPerson(@ModelAttribute Person person, Model model) {
    model.addAttribute("person", person);
    return "verify";
  }

  @PostMapping("/verify")
  @ResponseStatus(HttpStatus.OK)
  public String greetingSubmit(@ModelAttribute Person person, Model model) throws Exception {
    // gets result from verifyService
    Result result = verifyService.verifyPerson(person);
    String resultMessage = result.getMessage();

    model.addAttribute("resultmessage", resultMessage);

    return "result";
  }
}
