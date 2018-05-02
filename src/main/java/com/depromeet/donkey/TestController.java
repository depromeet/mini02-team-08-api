package com.depromeet.donkey;

import com.depromeet.donkey.domain.donkey.Account;
import com.depromeet.donkey.domain.donkey.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @Autowired AccountRepository accountRepository;

  @GetMapping("/")
  public Iterable<Account> findAll() {
    return accountRepository.findAll();
  }
}
