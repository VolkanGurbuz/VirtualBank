package com.volkangurbuz.currencyconverter.utilities;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Util {
  private static HttpClient client = HttpClient.newHttpClient();

  public static String sendGetRequest(String url) {

    try {
      HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      if (response.statusCode() == 200) {
        return response.body();
      }
    } catch (Exception e) {
      System.err.println("Failure , " + e.toString());
    }
    return null;
  }

  public static String getJsonValue(String key, String jsonString) throws JSONException {
    JSONObject jObj = new JSONObject(jsonString);

    String extract = jObj.getString(key);
    return extract;
  }

  public static double calculaterRate(String money, String currentRate) {
    double rateMoney = 0;
    try {
      rateMoney = Double.parseDouble(money) * Double.parseDouble(currentRate);
    } catch (NumberFormatException e) {
      throw new NumberFormatException();
    }
    return rateMoney;
  }
}
