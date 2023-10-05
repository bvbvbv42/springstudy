package com.gdu.app06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app06.dao.BoardDao;
import com.gdu.app06.dto.BoardDto;
import com.gdu.app06.service.BoardServiceImpl;
import com.gdu.app06.service.IBoardService;

@Configuration
public class BoardConfig {

    @Bean
    public BoardDto boardDto1() {         //bean의 이름(id) : boardDto1 , bean 의 클래스 : BoardDto
      return new BoardDto(1, "제목1", "작성자1");
    }
    
    @Bean
    public BoardDto boardDto2() {         //bean의 이름(id) : boardDto2 , bean 의 클래스 : BoardDto
      return new BoardDto(2, "제목2", "작성자2");
    }
    
    @Bean
    public BoardDto boardDto3() {         //bean의 이름(id) : boardDto3 , bean 의 클래스 : BoardDto
      return new BoardDto(3, "제목3", "작성자3");
    }
 
    @Bean
    public BoardDao boardDao() {          // 타입이하나뿐이라 이름은 보지않음
      return new BoardDao();
    }
    
    @Bean
    public IBoardService iBoardService() {
      return new BoardServiceImpl();
    }
    
    
}
