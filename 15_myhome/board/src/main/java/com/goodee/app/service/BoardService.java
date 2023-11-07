package com.goodee.app.service;

import java.util.List;

import com.goodee.app.dto.BoardDto;

public interface BoardService {
  public List<BoardDto> getBoardList();
  public int addBoard(BoardDto board);
  public BoardDto getBoardByNo(int boardNo);
  public int modifyBoard(BoardDto board);
  public int removeBoard(int boardNo);
  public int removeBoardList(String[] boardNoList);
}