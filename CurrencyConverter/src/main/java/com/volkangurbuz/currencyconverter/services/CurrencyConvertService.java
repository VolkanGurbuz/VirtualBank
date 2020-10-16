package com.volkangurbuz.currencyconverter.services;

import com.volkangurbuz.currencyconverter.domain.Currency;
import org.json.JSONException;

import java.io.IOException;
import java.util.Set;

public interface CurrencyConvertService {

  Currency getConvertedCurrency(String currency, String rate, String toConvertCurrency)
      throws JSONException;
}
