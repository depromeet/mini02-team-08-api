package com.depromeet.donkey.account;

import com.depromeet.donkey.domain.donkey.Account;
import com.depromeet.donkey.domain.donkey.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
  @Autowired AccountRepository accountRepository;

  public List<Account> findAll() {
    return accountRepository.findAll();
  }

  // FIXME not yet implemented
  public void update() {
  }

  // FIXME not yet implemented
  public void insert() {
  }

  // FIXME not yet implemented
  public void delete() {
  }
}
