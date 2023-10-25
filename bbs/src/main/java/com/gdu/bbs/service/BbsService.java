package com.gdu.bbs.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BbsService {
  //추상메소드를 만들고 실제 구현은 impl
  
  public void loadBbsList(HttpServletRequest request, Model model); // 이름은 자유롭게 만들어도 됨
    // request를 선택하면 요청파라미터말고 다른것도 사용해서 쓰는것이다.
    // 1. getParameter(page)로 파라미터를만드려고
    // 2. getContextPath()를 제공??? , 
    // getContextPath()를 사용할일이없으면 int page를 넣어도됨
    // Model에 실어줄게 2개이상일때 --> 서비스야 너가 저장해라~~~~~~~~
    // 저장할것이 하나면 controller가 받아서 저장한다.
}
