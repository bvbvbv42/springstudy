package com.gdu.app02.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainWrapper {

  public static void ex01() {
    
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml01/app-context.xml");
    
    
    
    
  }
}
