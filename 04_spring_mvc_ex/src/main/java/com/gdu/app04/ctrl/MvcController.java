package com.gdu.app04.ctrl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app04.vo.ArticleVo;

@Controller
public class MvcController {

  // DispatcherServlet(servlet-context.xml)에서 ViewResolver를 제거했으므로 JSP의 전체 경로를 모두 작성해야 한다.
  
  @RequestMapping(value="/" , method=RequestMethod.GET)        // 슬래시일때 밑에 코드를 수행하겠다., / < 슬래시는 localhost8080.app04 를 의미한다.
  public String main() {
    return "/WEB-INF/main.jsp";     // 이 jsp로 이동하겠다.
  }
  
  @RequestMapping(value="/write.do", method=RequestMethod.GET)
  public String write() {
    return "/WEB-INF/article/write.jsp";        // 여기로 이동(뷰가없기때문에 전체경로를 작성)
  }
  
  
  // 첫번째 요청 파라미터 방법
  // @RequestMapping(value="/register.do", method=RequestMethod.POST)
  public String register(HttpServletRequest request, Model model) {
    int articleNo = Integer.parseInt(request.getParameter("articleNo"));
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    model.addAttribute("articleNo", articleNo);
    model.addAttribute("title", title);
    model.addAttribute("content", content);
    return "/WEB-INF/article/result.jsp";
    }
  
  // 두번째 요청 파라미터 방법
  // @RequestMapping(value="/register.do", method=RequestMethod.POST)
  public String register2(@RequestParam(value="articleNo") int articleNo   // 받아온것을 인트 articleNo로 저장
                        , @RequestParam(value="title") String title
                        , @RequestParam(value="content") String content
                        , Model model) {
    
    ArticleVo vo = new ArticleVo(articleNo, title, content);
    model.addAttribute("vo", vo);
    return "/WEB-INF/article/result.jsp";
  }
  
  //세번째 요청 파라미터 방법  
  // 파라미터를 저장할 수 있는 필드를 가진 articleVo를 준비해서 알아서 만드는 방법
  // @RequestMapping(value="/register.do", method=RequestMethod.POST)
  public String register3(ArticleVo vo) {
    return "/WEB-INF/article/result.jsp";
    
  }
  
  @RequestMapping(value="/register.do", method=RequestMethod.POST)
  public String register4(@ModelAttribute(value="atcVo") ArticleVo vo) { // articlevo가아니라 vo로 저장해라
    return "/WEB-INF/article/result.jsp";
  }



}
