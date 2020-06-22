package com.volkangurbuz.verifysystem.services;

import com.volkangurbuz.verifysystem.domain.Person;
import com.volkangurbuz.verifysystem.utilities.Util;
import com.volkangurbuz.verifysystem.utilities.results.ErrorResult;
import com.volkangurbuz.verifysystem.utilities.results.Result;
import com.volkangurbuz.verifysystem.utilities.results.SuccessResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VerifyServiceImpl implements VerifyService {

  @Override
  public Result verifyPerson(Person person) {
    try {

      Util util = new Util();
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
