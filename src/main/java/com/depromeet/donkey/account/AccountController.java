package com.depromeet.donkey.account;

import com.depromeet.donkey.domain.donkey.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
  @Autowired AccountService accountService;

  @GetMapping
  public List<Account> fetchAll() {
    return accountService.findAll();
  }

  @PostMapping
  public void signUp(@RequestBody AccountRequest accountRequest) {
    accountService.signUp(accountRequest);
  }

  // FIXME need global exception handler
  @PostMapping("/sign-in")
  public void signIn(@RequestBody AccountRequest accountRequest) {
    accountService.signIn(accountRequest);
  }

  // FIXME not yet implemented
  @PutMapping("/{no}")
  public void update(@PathVariable Long no) {
    accountService.update();
  }

  // FIXME Authorization
  @DeleteMapping("/{no}")
  public void delete(@PathVariable Long no) {
    accountService.delete(no);
  }
}
