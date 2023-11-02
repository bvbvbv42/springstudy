package com.goodee.app.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDto {
  private int boardNo;
  private String writer;
  private String title;
  private String contents;
  private Timestamp createdAt;
  private Timestamp modifiedAt;
}
