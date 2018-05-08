package com.depromeet.donkey.domain.donkey.repository;

import com.depromeet.donkey.domain.donkey.Area;
import com.depromeet.donkey.domain.donkey.Post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface PostRepository extends JpaRepository<Post, Integer> {
  Stream<Post> findAllByArea(Area area);
}
