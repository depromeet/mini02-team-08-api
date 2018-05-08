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
@Table(name = "posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "no") Long no;

  @Column(name = "lat") Float lat;
  @Column(name = "lng") Float lng;
  @Column(name = "title") String title;
  @Column(name = "content") String content;
  @Column(name = "nickname") String nickname;
  @Column(name = "account_no") Long accountNo; // 매핑할 이유가 생긴다면, 객체 매핑으로

  // area
  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "area_no", updatable = false)
  private Area area;

  @CreatedDate @Column(name = "created_at") LocalDateTime createdAt;
  @CreatedDate @LastModifiedDate @Column(name = "expired_at") LocalDateTime expiredAt;

  public static Post from(PostRequest postRequest, Area area) {
    Post post = new Post();
    post.setLat(postRequest.getLat());
    post.setLng(postRequest.getLng());
    post.setTitle(postRequest.getTitle());
    post.setContent(postRequest.getContent());
    post.setNickname(postRequest.getNickname());
    post.setAccountNo(postRequest.getAccountNo());

    post.setExpiredAt(LocalDateTime.now().plusMonths(1));
    post.setCreatedAt(LocalDateTime.now());

    post.setArea(area);
    return post;
  }
}
