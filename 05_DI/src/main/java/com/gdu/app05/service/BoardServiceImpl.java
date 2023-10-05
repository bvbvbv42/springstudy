package com.gdu.app05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gdu.app05.dao.BoardDao;
import com.gdu.app05.dto.BoardDto;


@Service   // 서비스 계층(Business Layer) 전용 @Component, Spring Container에 BoardService BoardServiceImpl 객체를 생성해 둔다.
public class BoardServiceImpl implements BoardService {

  
  /*
   * BoardService DI 처리 방법
   * 1. BoardDao 타입의 객체를 Spring Container에 넣는다.( 아래 3가지중 하나 이용)
   *  1) <bean> 태그            : /WEB-INF/spring/root-context.xml
   *  2) @Configuration + @Bean : com.gdu.app05.config.AppConfig.java
   *  3) @Component 
   *  
   * 2. @Autowired 를 이용해서 Spring Container에서 BoardDao 타입의 객체를 가져온다.
   *  1) 필드에 주입하기
   *  2) 생성자에 주입하기
   *  3) Setter 형식의 메소드에 주입하기
   */
  
  @Autowired
  private BoardDao boardDao;
  
  
  /*
  @Autowired
  public BoardServiceImpl(BoardDao boardDao) {
    super();
    this.boardDao = boardDao;
  }

   


  @Autowired
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
*/




  @Override
  public List<BoardDto> getBoardlist() {
    return boardDao.getBoardList();
  }

}
