package com.gdu.app01.xml.anno01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration     //  IoContainer에 bean을 등록하는 클래스이다.
public class AppConfig {

  // 메소드를 bean으로 등록하기 위해서 @Bean을 추가한다.
  
  @Bean
  public Calculator calc() {
    return new Calculator();
  }
  
  
  
}
