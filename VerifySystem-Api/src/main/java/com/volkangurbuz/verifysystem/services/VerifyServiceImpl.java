package com.volkangurbuz.verifysystem.services;

import com.volkangurbuz.verifysystem.domain.Person;
import com.volkangurbuz.verifysystem.utilities.Util;
import com.volkangurbuz.verifysystem.utilities.results.ErrorResult;
import com.volkangurbuz.verifysystem.utilities.results.Result;
import com.volkangurbuz.verifysystem.utilities.results.SuccessResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class VerifyServiceImpl implements VerifyService {

  @Autowired Util util;

  @Override
  public Result verifyPerson(Person person) {
    try {
      boolean isValid = util.isValid(util.sendMessage(person));

      if (isValid) {
        return new SuccessResult(true, "The person is valid.");
      } else {
        return new ErrorResult(false, "The person is not valid.");
      }

    } catch (Exception e) {
      return new ErrorResult(false, e.getMessage());
    }
  }
}
