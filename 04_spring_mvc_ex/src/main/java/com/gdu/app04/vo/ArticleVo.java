package com.gdu.app04.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 객체 만들기?

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleVo {
  private int articleNo;
  private String title;
  private String content;
}
