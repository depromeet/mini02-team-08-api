package com.depromeet.donkey.domain.donkey.repository;

import com.depromeet.donkey.domain.donkey.Account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
  Optional<Account> findByEmailAndPassword(String email, String password);
}
