package com.depromeet.donkey.account;

import com.depromeet.donkey.domain.donkey.Account;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.depromeet.donkey.util.LocalDateTimeToInstant.toInstant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse implements Serializable {
  private Long no;
  private String email;
  private String name;

  // LocalDateTime 의 경우 타임존을 빼먹고 파싱하기 떄문에, Instant 로(ISO8106)
  Instant lastAccessAt;
  Instant createdAt;
  Instant updatedAt;


  public static AccountResponse from(Account account) {
    return new AccountResponse(account.getNo(), account.getEmail(), account.getName(),
        toInstant(account.getLastAccessAt()),
        toInstant(account.getCreatedAt()),
        toInstant(account.getUpdatedAt()));
  }
}
