package com.depromeet.donkey.post;

import com.depromeet.donkey.account.AccountRequest;
import com.depromeet.donkey.area.AreaService;
import com.depromeet.donkey.domain.donkey.Account;
import com.depromeet.donkey.domain.donkey.Area;
import com.depromeet.donkey.domain.donkey.Post;
import com.depromeet.donkey.domain.donkey.Report;
import com.depromeet.donkey.domain.donkey.repository.PostRepository;
import com.depromeet.donkey.domain.donkey.repository.ReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
public class PostService {
  @Autowired PostRepository postRepository;
  @Autowired ReportRepository reportRepository;
  @Autowired AreaService areaService;

  @Transactional
  public List<PostResponse> findAll(String si, String gu, String dong) {
    return postRepository.findAllByArea(areaService.findOneAndIfNotExistCreate(si, gu, dong))
    	.filter(new Predicate<Post>() {
			@Override
			public boolean test(Post t) {
				boolean securePost = t.getReportsList().size()<6;
				return securePost;
			}
		})
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

  public void report(ReportRequest reportRequest, Long postNo) {
	  reportRepository.save(Report.from(reportRequest, postNo));
	  }
}
