package com.gdu.bbs.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.bbs.dao.BbsMapper;
import com.gdu.bbs.dto.BbsDto;
import com.gdu.bbs.util.MyPageUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BbsServiceImpl implements BbsService {

  private final BbsMapper bbsMapper;
  private final MyPageUtils myPageUtils;
  // 서비스는 언제나 Mapper을 사용해야한다.
  // final을 사용해서 @RequiredArgsConstructor 사용해야함
  // 그다음 bbsMapper

  @Override
  public void loadBbsList(HttpServletRequest request, Model model) {

   
   
    Optional<String> opt = Optional.ofNullable(request.getParameter("page"));  //파라미터 페이지를 한번 감싸주세요
    String strPage = opt.orElse("1");  //null이면 1주이소
    int page = Integer.parseInt(strPage); // 모든 파라미터는 문자열이다 
                                          //주소창에 page = 가없으면 1page를 보여주는게 약속이다~!!!!!
    
    int total = bbsMapper.getBbsCount();
    
    int display = 10;
    
    myPageUtils.setPaging(page, total, display);
    
    Map<String, Object> map = Map.of("begin", myPageUtils.getBegin()
                                   , "end", myPageUtils.getEnd());
    
    List<BbsDto> bbsList =  bbsMapper.getBbsList(map);  //bbsMapper.getBbsList(map); //받아오는 쿼리 
    
    //보내고싶은것을 저장하는곳 = model
    model.addAttribute("bbsList",bbsList);
    String contextPath =request.getContextPath();
    model.addAttribute("paging", myPageUtils.getMvcPaging(contextPath + "/bbs/list/do"));  //마이페이지유틸스 sb.append쪽에있음 ,, /bbs/list/do" 여기면 목록을보여주
    model.addAttribute("total", total);
  
  }
  
  
  @Override
  public BbsDto getBbs(int bbsNo) {
    // 추상메소드를 만드는것을 override라고 한다.
    BbsDto bbs = bbsMapper.getBbs(bbsNo);        //bbsMapper.getBbs(bbsNo); ->mapper에 getBbs를 만들어서 bbsNo 를 전달해줘라
    // bbs가 결과다
    return bbs;
  }
  
  @Override
  public int addBbs(BbsDto bbs) {    //사용자가 입력한게 bbs에 있음
    return bbsMapper.insertBbs(bbs);
    
  }
  
}
