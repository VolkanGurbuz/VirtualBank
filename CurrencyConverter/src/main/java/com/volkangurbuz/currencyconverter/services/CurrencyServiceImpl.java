package com.volkangurbuz.currencyconverter.services;

import com.volkangurbuz.currencyconverter.controller.CurrencyServiceController;
import com.volkangurbuz.currencyconverter.domain.Currency;
import com.volkangurbuz.currencyconverter.exceptions.NotFoundException;
import com.volkangurbuz.currencyconverter.repositories.CurrencyRepository;
import com.volkangurbuz.currencyconverter.utilities.Sources;
import com.volkangurbuz.currencyconverter.utilities.Util;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyConvertService {
  Logger logger = LoggerFactory.getLogger(CurrencyServiceController.class);

  @Override
  public Currency getConvertedCurrency(String currency, String rate, String toConvertCurrency)
      throws JSONException {
    String endPointUrl = String.format(Sources.CONVERT_URL, toConvertCurrency, currency);
    String result = Util.sendGetRequest(endPointUrl);
    Currency currencyConverted = new Currency();

    if (result == null) {
      throw new NotFoundException("please insert the post body");

    } else {
      String rates = Util.getJsonValue("rates", result);
      String date = Util.getJsonValue("date", result);
      String currentRate = Util.getJsonValue(toConvertCurrency, rates);
      double moneyRate = Util.calculaterRate(rate, currentRate);
      logger.info("rate:" + moneyRate + " as " + currentRate + " rate " + rate);
      currencyConverted.setDate(date);
      currencyConverted.setCurrencyType(toConvertCurrency);
      currencyConverted.setRate(moneyRate + "");
    }
    return currencyConverted;
  }
}
