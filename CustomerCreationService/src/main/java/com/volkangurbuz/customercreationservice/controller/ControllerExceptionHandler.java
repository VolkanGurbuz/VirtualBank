package com.volkangurbuz.customercreationservice.controller;
;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

// @ControllerAdvice is a specialization of the @Component annotation which allows to handle
// exceptions across the whole application in one global handling component.
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(NumberFormatException.class)
  public ModelAndView handleNumberFormat(Exception exception) {

    log.error("Handling Number format Exception");
    log.error(exception.getMessage());
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("exception", exception);

    modelAndView.setViewName("400error");

    return modelAndView;
  }
}
