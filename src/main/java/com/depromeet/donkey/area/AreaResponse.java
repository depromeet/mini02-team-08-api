package com.depromeet.donkey.area;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaResponse implements Serializable {
  private String si;
  private String gu;
  private String dong;
}
