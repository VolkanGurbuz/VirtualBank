package com.volkangurbuz.verifysystem.services;

import com.volkangurbuz.verifysystem.domain.Person;
import com.volkangurbuz.verifysystem.utilities.results.Result;

public interface VerifyService {
  Result verifyPerson(Person person) throws Exception;
}
