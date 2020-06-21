package com.volkangurbuz.verifysystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
  private String tcNo;
  private String name;
  private String surName;
  private String birthday;
}
