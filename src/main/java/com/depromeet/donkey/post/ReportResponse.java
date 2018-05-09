package com.depromeet.donkey.post;

import com.depromeet.donkey.domain.donkey.Report;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReportResponse implements Serializable {
  private Long accountNo;
  private Long postNo;

  public static ReportResponse from(Report report) {
    ReportResponse response = new ReportResponse();
    response.accountNo = report.getAccountNo();
    response.postNo = report.getPostNo();
    return response;
  }
}
