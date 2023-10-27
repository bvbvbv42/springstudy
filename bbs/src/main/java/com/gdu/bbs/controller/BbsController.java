package com.gdu.bbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.bbs.dto.BbsDto;
import com.gdu.bbs.service.BbsService;

import lombok.RequiredArgsConstructor;


// 컨트롤러를 실행할 jsp

@RequiredArgsConstructor                          // final로만들어진 filed는 일반생성자 x
@Controller                                       // 컨트롤러는 무조건 서비스와 연결
public class BbsController {

  private final BbsService bbsService;
  
  
  // select는 model에 저장한 뒤 forward한다.
  @GetMapping("/list.do")
  public String list(HttpServletRequest request, Model model) {
    bbsService.loadBbsList(request, model);  // 위에선언한거 다줘 // 서비스가 다저장함
    return "bbs/list";   //bbs폴더와 list.jsp를 의미함
  }
  
  //select는 model에 저장한 뒤 forward한다.
  @GetMapping("/detail.do")
  public String detail(@RequestParam(value="bbsNo", required=false, defaultValue="0") int bbsNo
             , Model model) {   // 주소창?뒤에 있는 전달값(파라미터)를 가져온다, required=false => 꼭필요한건아니다
    BbsDto bbs = bbsService.getBbs(bbsNo);   //getbbs를부르시고 bbsNo를 전달해주세요 
    model.addAttribute("bbs", bbs);   //bbs라는 이름으로 bbs객체를넘겨준다
    return "bbs/detail";
  }    

                                            // insert는 redirectAttributes에 저장한 뒤 redirect한다.
  @PostMapping("/add.do")                   //컨트롤의반환은 어디로가겠습니다!!!!
  public String add(BbsDto bbs, RedirectAttributes attr) {             //  ()안으로 받음 <div><input type="text" name="editor" id="editor" placeholder="작성자"></div>
                                            //                <div><input type="text" name="title" id="title" placeholder="제목" required></div>  <!-- title은 NOT NULL이라 정보가있어야한다 , required -> 이입력란을 입력하세요-->
                                            //                <div><input type="text" name="contents" id="contents" placeholder="작성자"></div>
                                            // 알아서 3개가 들어감
                        
    int addResult = bbsService.addBbs(bbs);                 // 그리고 전달
    attr.addFlashAttribute("addResult", addResult);
    return "redirect:/list.do";             // redirect는 mapping(괄호)안에 있는것을 넣는다
  }
  
  // 묻지말고 외워라!!!!!
 
 
  // update는 redirectAttribute에 저장한 뒤 redirect 한다.   
  @PostMapping("/modify.do")
  public String modify(BbsDto bbs, RedirectAttributes attr) { // 3개니까 커맨드객체를 사용하는게 좋지
    int modifyResult = bbsService.modifyBbs(bbs);
    attr.addFlashAttribute("modifyResult", modifyResult);
    return "redirect:/detail.do?bbsNo=" + bbs.getBbsNo();   // detail.do 에 @RequestParam(value="bbsNo
  }
  
  // delete는 redirectAttribute에 저장한 뒤 redirect 한다.
  @PostMapping("/remove.do")
  public String remove(@RequestParam(value="bbsNo", required=false, defaultValue="0") int bbsNo    // 하나만 받으면 되니깐 키값으로만
                     , RedirectAttributes attr) {
    int removeResult = bbsService.removeBbs(bbsNo);
    attr.addFlashAttribute("removeResult", removeResult);
    return "redirect:/list.do";
  }
  
  
  
  
  
  
 }
