package com.gdu.prj01.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.gdu.prj01.config.AppConfig;
import com.gdu.prj01.dto.BoardDto;

public class MainWrapper {

  public static void main(String[] args) {
    
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("com/gdu/prj01/app-context.xml");
    BoardDto boardDto = ctx.getBean("board1", BoardDto.class);          // 가져오는것
    //BoardDto 타입의 boardDto에 저장
    System.out.println(boardDto);
    ctx.close();
    
    
    AbstractApplicationContext ctx2 = new AnnotationConfigApplicationContext(AppConfig.class);  // ()안은 클래스지정 
    BoardDto boardDto3 = ctx2.getBean("board3", BoardDto.class);
        System.out.println(boardDto3);
        ctx2.close();
    
    
  }

}
