package com.volkangurbuz.currencyconverter.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Currency {

  private String rate;
  private String date;
  private String currencyType;
}
