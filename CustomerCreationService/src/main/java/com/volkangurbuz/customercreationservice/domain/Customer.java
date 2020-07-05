package com.volkangurbuz.customercreationservice.domain;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
  private String address;

  @Nullable private List<CreditCard> creditCards;

  @Nullable private List<BankAccount> bankAccounts;
}
