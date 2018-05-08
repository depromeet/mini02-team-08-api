package com.depromeet.donkey.account;

import com.depromeet.donkey.domain.donkey.Account;
import com.depromeet.donkey.domain.donkey.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AccountService {
  @Autowired AccountRepository accountRepository;

  public List<AccountResponse> findAll() {
    return accountRepository.findAll().stream()
        .map(AccountResponse::from)
        .collect(Collectors.toList());
  }

  // FIXME not yet implemented
  public void update() {
  }

  public void signUp(AccountRequest accountRequest) {
    accountRepository.save(Account.from(accountRequest));
  }

  // FIXME not yet implemented
  public void delete(Long no) {
    accountRepository.delete(no);
  }

  // TODO encryption. Can use spring-security
  // @see https://docs.spring.io/spring-security/site/docs/4.2.4.RELEASE/apidocs/org/springframework/security/crypto/bcrypt/BCryptPasswordEncoder.html
  public void signIn(AccountRequest accountRequest) {
    accountRepository.findByEmailAndPassword(
        accountRequest.getEmail(), accountRequest.getPassword()
    ).orElseThrow(() -> new NoSuchElementException("user not found"));
  }
}
