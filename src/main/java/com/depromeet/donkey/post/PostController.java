package com.depromeet.donkey.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.depromeet.donkey.area.AreaRequest;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
  @Autowired PostService postService;

  @ApiOperation(value = "포스트 목록 조회",
      notes = "도메인:port/api/v1/posts?si=Seoul&gu=Joong-gu&dong=cheongu 같은 방식으로 요청")
  @GetMapping
  public List<PostResponse> fetchAll(
      @RequestParam String si, @RequestParam String gu, @RequestParam String dong) {
    return postService.findAll(si, gu, dong);
  }

  @ApiOperation(value = "포스트 작성",
      notes = "{\n" +
          "\t\"lat\": 11.11,\n" +
          "\t\"lng\": 11.11,\n" +
          "\t\"title\": \"title\",\n" +
          "\t\"content\": \"content\",\n" +
          "\t\"nickname\": \"22\",\n" +
          "\t\"accountNo\": 1,\n" +
          "\t\"areaNo\": 1,\n" +
          "\t\"si\": \"Seoul\",\n" +
          "\t\"gu\": \"Joong-gu\",\n" +
          "\t\"dong\": \"cheongu\"\n" +
          "}" +
          "등의 형식으로 request-body 에 요청")
  @PostMapping
  public void write(@RequestBody PostRequest postRequest) {
    postService.write(postRequest);
  }

  @ApiOperation(value = "업데이트",
      notes = "미구현")
  // FIXME not yet implemented
  @PutMapping("/{no}")
  public void update(@PathVariable Long no) {
    postService.update();
  }
  @ApiOperation(value = "신고하기",
	      notes = "신고하기")
  @PostMapping("/reportInsert/{accountNo}/{postNo}")
  public void reportInsert(@PathVariable Long accountNo, @PathVariable Long postNo) {
	  postService.reportInsert(accountNo, postNo);
  }

//  @ApiOperation(value = "삭제",
//      notes = "미구현")
//  // FIXME Authorization
//  @DeleteMapping("/{no}")
//  public void delete(@PathVariable Long no) {
//    postService.delete(no);
//  }
}
