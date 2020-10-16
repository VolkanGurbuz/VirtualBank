package com.volkangurbuz.currencyconverter.controller;

import com.volkangurbuz.currencyconverter.domain.Currency;
import com.volkangurbuz.currencyconverter.exceptions.NotFoundException;
import com.volkangurbuz.currencyconverter.services.CurrencyConvertService;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyServiceController {
  Logger logger = LoggerFactory.getLogger(CurrencyServiceController.class);

  private final CurrencyConvertService currencyConvertService;

  public CurrencyServiceController(CurrencyConvertService currencyConvertService) {
    this.currencyConvertService = currencyConvertService;
  }
  /*
  @PostMapping
  @RequestMapping("/convert")
  @ExceptionHandler(NotFoundException.class)
  public String listCurrencyTypes(@ModelAttribute Currency currency, Model model)
      throws JSONException {
    model.addAttribute("currency", currency);

    if (currency.getCurrencyType() != null && currency.getRate() != null) {
      String rate = currency.getRate() + "";
      String currencyType = currency.getCurrencyType().split(",")[0];
      String toCurrencyType = currency.getCurrencyType().split(",")[1];

      Currency convertedCurrency =
          currencyConvertService.getConvertedCurrency(currencyType, rate, toCurrencyType);

      model.addAttribute("convertedcurrency", convertedCurrency);
    }

    return "converter";
  }*/

  @RequestMapping(value = "/api/getconvert", method = RequestMethod.POST)
  @ExceptionHandler(NotFoundException.class)
  public Currency getCurrency(@RequestBody Currency currency) throws JSONException {
    Currency convertedCurrency = null;
    if (currency.getCurrencyType() != null && currency.getRate() != null) {
      String rate = currency.getRate() + "";
      String currencyType = currency.getCurrencyType().split(",")[0];
      String toCurrencyType = currency.getCurrencyType().split(",")[1];

      convertedCurrency =
          currencyConvertService.getConvertedCurrency(currencyType, rate, toCurrencyType);
    }

    return convertedCurrency;
  }
}
