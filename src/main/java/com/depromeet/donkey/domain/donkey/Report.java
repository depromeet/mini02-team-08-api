package com.depromeet.donkey.domain.donkey;


import com.depromeet.donkey.post.ReportRequest;

import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@NoArgsConstructor
@Entity
@Table(name = "reports")
@IdClass(ReportId.class)
public class Report {

  @Id
  @Column(name = "account_no")
  Long accountNo;
  @Id
  @Column(name = "post_no")
  Long postNo;

  @CreatedDate @Column(name = "created_at") LocalDateTime createdAt;

  public static Report from(ReportRequest reportRequest, Long postNo) {
    Report report = new Report();
    report.setAccountNo(reportRequest.getAccountNo());
    report.setCreatedAt(LocalDateTime.now());
    report.setPostNo(postNo);
    return report;
  }
}
