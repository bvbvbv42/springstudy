package com.gdu.app04.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MvcController {

  // DispatcherServlet(servlet-context.xml)에서 ViewResolver를 제거했으므로 JSP의 전체 경로를 모두 작성해야 한다.
  
  @RequestMapping(value="/" , method=RequestMethod.GET)        // 슬래시일때 밑에 코드를 수행하겠다., / < 슬래시는 localhost8080.app04 를 의미한다.
  public String main() {
    return "/WEB-INF/main.jsp";     // 이 jsp로 이동하겠다.
  }
  
  
}
