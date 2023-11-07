package com.goodee.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.app.dto.BoardDto;

@Mapper
public interface BoardMapper {
  public List<BoardDto> getBoardList();
  public int insertBoard(BoardDto board);
  public BoardDto getBoardByNo(int boardNo);
  public int updateBoard(BoardDto board);
  public int deleteBoard(int boardNo);
  public int deleteBoardList(List<String> boardNoList);
}
