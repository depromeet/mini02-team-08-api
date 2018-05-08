package com.depromeet.donkey.account;

import com.depromeet.donkey.domain.donkey.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
  @Autowired AccountService accountService;

  @ApiOperation(value = "유저목록 조회",
      notes = "사용 용도 없음. 그냥 만들어 보았음.ㅎㅎ 그리고 쓰면 안됨")
  @GetMapping
  public List<AccountResponse> fetchAll() {
    return accountService.findAll();
  }

  @ApiOperation(value = "회원가입",
      notes = "이메일, 패스워드를 request body 에 담아서 보냅니다.")
  @PostMapping
  public void signUp(@RequestBody AccountRequest accountRequest) {
    accountService.signUp(accountRequest);
  }

  @ApiOperation(value = "로그인",
      notes = "회원가입과 같음")
  @PostMapping("/sign-in")
  public void signIn(@RequestBody AccountRequest accountRequest) {
    accountService.signIn(accountRequest);
  }


  @ApiOperation(value = "업데이트",
      notes = "미구현")
  // FIXME not yet implemented
  @PutMapping("/{no}")
  public void update(@PathVariable Long no) {
    accountService.update();
  }

  @ApiOperation(value = "삭제",
      notes = "미구현")
  // FIXME Authorization
  @DeleteMapping("/{no}")
  public void delete(@PathVariable Long no) {
    accountService.delete(no);
  }
}
