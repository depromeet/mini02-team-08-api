package com.depromeet.donkey.domain.donkey;


import com.depromeet.donkey.account.AccountRequest;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "no") Long no;

  @Column(name = "email") String email;
  @Column(name = "name") String name;
  @Column(name = "password") String password;

  @LastModifiedDate @Column(name = "last_access_at") LocalDateTime lastAccessAt;
  @CreatedDate @Column(name = "created_at") LocalDateTime createdAt;
  @CreatedDate @LastModifiedDate @Column(name = "updated_at") LocalDateTime updatedAt;

  public static Account from(AccountRequest accountRequest) {
    Account account = new Account();
    account.setEmail(accountRequest.getEmail());
    account.setName(accountRequest.getName());
    account.setPassword(accountRequest.getPassword());

    account.setUpdatedAt(LocalDateTime.now());
    account.setCreatedAt(LocalDateTime.now());
    return account;
  }
}
