package com.goodee.app.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.goodee.app.dao.BoardMapper;
import com.goodee.app.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

  private final BoardMapper boardMapper;


  @Override
  public void loadBoardList(HttpServletRequest request, Model model) {
    
    model.addAttribute("boardList", boardMapper.getBoardList());
    
  }
  
  @Override
  public int addBoard(BoardDto board) {
     
    return boardMapper.insertBoard(board);
  }
}