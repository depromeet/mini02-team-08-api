package com.depromeet.donkey.domain.donkey.repository;

import com.depromeet.donkey.domain.donkey.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
