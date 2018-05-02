package com.depromeet.donkey.entity.repository;

import com.depromeet.donkey.entity.Account;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
