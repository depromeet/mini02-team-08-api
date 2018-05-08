package com.depromeet.donkey.post;

import com.depromeet.donkey.area.AreaService;
import com.depromeet.donkey.domain.donkey.Area;
import com.depromeet.donkey.domain.donkey.Post;
import com.depromeet.donkey.domain.donkey.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
public class PostService {
  @Autowired PostRepository postRepository;
  @Autowired AreaService areaService;

  @Transactional
  public List<PostResponse> findAll(String si, String gu, String dong) {
    return postRepository.findAllByArea(areaService.findOneAndIfNotExistCreate(si, gu, dong))
        .map(PostResponse::from)
        .collect(Collectors.toList());
  }

  @Transactional
  public void write(PostRequest postRequest) {
    Area area = areaService.findOneAndIfNotExistCreate(postRequest.getSi(), postRequest.getGu(), postRequest.getDong());
    postRepository.save(Post.from(postRequest, area));
  }

  // FIXME not yet implemented
  public void update() {
  }

}
