package com.goodee.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.goodee.app.dao.BoardMapper;
import com.goodee.app.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

  private final BoardMapper boardMapper;
  
  @Override
  public List<BoardDto> getBoardList() {
    return boardMapper.getBoardList();
  }

  @Override
  public int addBoard(BoardDto board) {
    return boardMapper.insertBoard(board);
  }
  
  @Override
  public BoardDto getBoardByNo(int boardNo) {
    return boardMapper.getBoardByNo(boardNo);
  }

  @Override
  public int modifyBoard(BoardDto board) {
    return boardMapper.updateBoard(board);
  }

  @Override
  public int removeBoard(int boardNo) {
    return boardMapper.deleteBoard(boardNo);
  }
  
  @Override
  public int removeBoardList(String[] boardNoList) {
    return boardMapper.deleteBoardList(Arrays.asList(boardNoList));
  }
  
}
