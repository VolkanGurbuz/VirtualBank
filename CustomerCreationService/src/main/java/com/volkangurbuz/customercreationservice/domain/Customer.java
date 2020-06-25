package com.volkangurbuz.customercreationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customer")
public class Customer {

  @BsonId private String id;
  private String tcno;
  private String birthdate;
  private String name;
  private String surName;
  private String email;
  private String password;
  private String address;
}
