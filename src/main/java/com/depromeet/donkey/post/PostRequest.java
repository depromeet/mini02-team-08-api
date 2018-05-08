package com.depromeet.donkey.post;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest implements Serializable {
  private Integer areaNo;
  private Float lat;
  private Float lng;
  private String title;
  private String content;
  private String nickname;
  private Long accountNo;


  // for query
  private String si;
  private String gu;
  private String dong;

  // for report
  private Long postNo;
}
