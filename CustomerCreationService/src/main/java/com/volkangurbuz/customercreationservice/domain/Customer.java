package com.volkangurbuz.customercreationservice.domain;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Slf4j
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
  private String surname;
  private String email;
  private String password;
  private String passwordConfirm;
  private String address;
  private double balance;

  @Nullable private CreditCard creditCards;

  @Nullable private BankAccount bankAccounts;

  public void deposit(double depositBalance) {
    balance += depositBalance;
  }

  public void withDraw(double withDrawBalance) {
    if (withDrawBalance > getBalance())
      log.error("less balance you have, please check your current balance");
    else {
      balance -= withDrawBalance;
      log.info("you withdrawed the money + " + withDrawBalance);
      log.info("current balance is " + balance);
    }
  }
}
