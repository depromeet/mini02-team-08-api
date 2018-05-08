package com.depromeet.donkey.post;

import com.depromeet.donkey.domain.donkey.Post;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse implements Serializable {
  private Integer areaNo;
  private Float lat;
  private Float lng;
  private String title;
  private String content;
  private String nickname;
  private Long accountNo;

  public static PostResponse from(Post post) {
    PostResponse postResponse = new PostResponse();
    postResponse.setAreaNo(post.getArea().getNo());
    postResponse.setLat(post.getLat());
    postResponse.setLng(post.getLng());
    postResponse.setTitle(post.getTitle());
    postResponse.setContent(post.getContent());
    postResponse.setNickname(post.getNickname());
    postResponse.setAccountNo(post.getAccountNo());
    return postResponse;
  }
}
