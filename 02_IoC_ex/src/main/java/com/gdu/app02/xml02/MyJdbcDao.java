package com.gdu.app02.xml02;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyJdbcDao {

  private Connection con;
  
  public Connection getConnection() {
    // 반환값 : MyJdbcConnction 클래스의 getConnection() 메소드를 호출
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml02/appCtx.xml");
    MyJdbcConnection myJdbcConnection = ctx.getBean("myJdbcConnection", MyJdbcConnection.)
    ctx.close();
    return MyJdbcConnection.getConnection();
  
  }
  
  public void add() {
    
    
  }
  
  public void remove() {
    
    
  }
  public void modify() {
    
    
  }
  public void delete() {
    
    
  }
}
