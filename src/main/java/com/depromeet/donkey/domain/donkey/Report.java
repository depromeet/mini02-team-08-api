package com.depromeet.donkey.domain.donkey;


import com.depromeet.donkey.post.PostRequest;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@Entity
@Table(name = "reports")
public class Report {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "account_no") Long accountNo; 
  @Column(name = "post_no") Long postNo;

  @CreatedDate @Column(name = "created_at") LocalDateTime createdAt;

  public static Report from(Long accountNo, Long postNo) {
    Report report = new Report();
    report.setAccountNo(accountNo);
    report.setCreatedAt(LocalDateTime.now());
    report.setPostNo(postNo);
    return report;
  }
}
