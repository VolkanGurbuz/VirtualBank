package com.volkangurbuz.verifysystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
  private String tcNo;
  private String name;
  private String surname;
  private String birthday;
}
