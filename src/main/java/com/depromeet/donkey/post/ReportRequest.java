package com.depromeet.donkey.post;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequest implements Serializable {
  private Long accountNo;
}
