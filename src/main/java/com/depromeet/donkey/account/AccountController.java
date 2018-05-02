package com.depromeet.donkey.account;

import com.depromeet.donkey.domain.donkey.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
  @Autowired AccountService accountService;

  // FIXME not yet implemented
  @GetMapping
  public List<Account> fetchAll() {
    return accountService.findAll();
  }

  // FIXME not yet implemented
  @PostMapping
  public void insert() {
    accountService.insert();
  }

  // FIXME not yet implemented
  @PutMapping("/{id}")
  public void update(@PathVariable Long id) {
    accountService.update();
  }
}
