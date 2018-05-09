package com.depromeet.donkey.post;

import com.depromeet.donkey.domain.donkey.Post;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.depromeet.donkey.util.LocalDateTimeToInstant.toInstant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse implements Serializable {
  private Long postNo;
  private Integer areaNo;
  private Float lat;
  private Float lng;
  private String title;
  private String content;
  private String nickname;
  private Long accountNo;
  private Instant createdAt;
  private Instant expiredAt;

  private List<ReportResponse> reportResponse;

  public static PostResponse from(Post post) {
    PostResponse postResponse = new PostResponse();
    postResponse.setPostNo(post.getNo());
    postResponse.setAreaNo(post.getArea().getNo());
    postResponse.setLat(post.getLat());
    postResponse.setLng(post.getLng());
    postResponse.setTitle(post.getTitle());
    postResponse.setContent(post.getContent());
    postResponse.setNickname(post.getNickname());
    postResponse.setAccountNo(post.getAccountNo());
    postResponse.setCreatedAt(toInstant(post.getCreatedAt()));
    postResponse.setExpiredAt(toInstant(post.getExpiredAt()));

    postResponse.setReportResponse(
        post.getReportsList().stream()
            .map(ReportResponse::from)
            .collect(Collectors.toList())
    );
    return postResponse;
  }
}
