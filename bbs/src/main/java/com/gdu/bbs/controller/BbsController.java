package com.gdu.bbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.bbs.service.BbsService;

import lombok.RequiredArgsConstructor;


// 컨트롤러를 실행할 jsp

@RequiredArgsConstructor                          // final로만들어진 filed는 일반생성자 x
@Controller                                       // 컨트롤러는 무조건 서비스와 연결
public class BbsController {

  private final BbsService bbsService;
  
  @GetMapping("/bbs/list.do")
  public String list(HttpServletRequest request, Model model) {
    bbsService.loadBbsList(request, model);  // 위에선언한거 다줘 // 서비스가 다저장함
    return "bbs/list";   //bbs폴더와 list.jsp를 의미함
  }
}
