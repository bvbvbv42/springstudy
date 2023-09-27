package com.gdu.app03.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController04 {

  
/************************** 세션에 저장하기 ***************************/  
  
  
  
  /*
   * 1. HttpServletRequest로부터 HttpSession 얻기
   */
  
  //@GetMapping("/article/add.do")
  public String articleAdd(HttpServletRequest request) {

    // ViewResolver의 prefix : /WEB-INF/views/
    // ViewResolver의 suffix : .jsp
    
    HttpSession session = request.getSession();
    session.setAttribute("title", request.getParameter("title"));
    
    return "article/result";   //   /WEB-INF/views/article/result.jsp
    
  }
  
  
  /*
   *  2. HttpSession 선언하기
   */

  @GetMapping("/article/add.do")
  public String add2(HttpSession session, HttpServletRequest request) {
    session.setAttribute("title", request.getParameter("title"));
    return "article/result";
  
  
}

  
/****************************** 세션 정보 삭제하기 ******************************/
  
  /*
   * 1. HttpSession 의 invalidate() 메소드
   */
  
  @GetMapping("/article/main.do")
  public String main(HttpSession session) {
    
    // session 정보 초기화
    session.invalidate(); // 타이틀 값 저장한거 지워짐
    
    return "index";       // main으로 돌아감(prefix값으로 views까지는 기본적으로 경로 설정)

  
  }
  
  
}

