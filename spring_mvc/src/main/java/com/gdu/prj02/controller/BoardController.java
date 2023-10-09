package com.gdu.prj02.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.prj02.dto.BoardDto;
import com.gdu.prj02.service.BoardServcie;
import com.gdu.prj02.service.BoardServiceImpl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor  // final BoardService boardService에 Bean이 반드시 전달됨을 보증하는 Annotation
@Controller
public class BoardController {

  
  /*
  // index에서 요청한거 받는 메소드 3가지
   
  @RequestMapping(value="/add.do", method=RequestMethod.GET)
  public String add(HttpServletRequest request) { // 요청 파라미터는 메소드 파라미터로 받습니다.
    int boardNo = Integer.parseInt(request.getParameter("boardNo"));
    String title = request.getParameter("title");
    System.out.println(boardNo + ", " + title);
    return "";
  }
  */
  
  /*
  @RequestMapping(value="/add.do", method=RequestMethod.GET)
  public String add(@RequestParam(value="boardNo", required= false, defaultValue="0") int boardNo, @RequestParam(value="title")String title) {
                      // ()안에 int boardNo, String title 도가능함
    System.out.println(boardNo + ", " + title);
    return null;
  }
  */
  
  /*
  @RequestMapping(value="/add.do", method=RequestMethod.GET)
  public String add(BoardDto boardDto) {
    System.out.println(boardDto);
      return "";
      
    }
  
  */
  
  // 1. 필드 DI
  //@Autowired   // @Service로 만들어진 Bean을 가져오세요.
  //private BoardServcie boardService;
  
//  // 2. Setter 형식 메소드 DI
//  private BoardServcie boardService;
//  
//  @Autowired  // @Service로 만들어진 Bean을 매개변수로 가져오세요. 
//  public void setBoardService(BoardServcie boardService) {
//    this.boardService = boardService;
//  }

  // 3.생성자 DI
//  private BoardServcie boardService;
//  
//  
//  @Autowired // @Service로 만들어진 Bean을 매개변수로 가져오세요.(BoardServcie boardService로 가져온다)-> 가져온것을 필드로 처리  , @AutoWired 생략가능 (아래에있음)
//  public BoardController(BoardServcie boardService) {
//    super();
//    this.boardService = boardService;
//  }

  private final BoardServcie boardService;
  
  
  
  @RequestMapping(value="/add1.do", method=RequestMethod.GET)
  public String add(HttpServletRequest request, Model model) {     // 요청 파라미터는 메소드 파라미터로 받습니다.
    int result = boardService.add1(request);
    model.addAttribute("result", result);     // JSP로 전달하는 result 속성입니다.
    return "output";  // output.jsp로 forward (forward는 JSP 경로를 작성합니다.
  }
 
  @RequestMapping(value="/add2.do", method=RequestMethod.GET)
  public String add(int boardNo, String title, Model model) {
    model.addAttribute("result", boardService.add2(boardNo, title));
    return "output";
  }
  
  @RequestMapping(value="/add3.do", method=RequestMethod.GET)
  public String add3(BoardDto boardDto, Model model, RedirectAttributes redirectAttributes) {
    int result = boardService.add3(boardDto);
    // model.addAttribute("result", result);    //Model은 redirect 할 때 값을 전달하지 못합니다.
      redirectAttributes.addFlashAttribute("result", result); //RedirectAttributes는 redirect 할때 값을 전달합니다.
      return "redirect:/output.do";   // output.do라는 새로운 요청(redirect)을 처리하시오.
      
    }
  @RequestMapping(value="/output.do", method=RequestMethod.GET)
  public String output() {
    return "output";
  }


}
  
  
  

