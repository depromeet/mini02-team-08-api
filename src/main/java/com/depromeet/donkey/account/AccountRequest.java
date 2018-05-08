package com.depromeet.donkey.account;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest implements Serializable {
  private String email;
  private String name;
  private String password;
}
