package com.goodee.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goodee.app.dto.BoardDto;
import com.goodee.app.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {

  private final BoardService boardService;
  
  @GetMapping("/")
  public String index() {
    return "index";
  }
  
  @GetMapping("/board/list.do")
  public String list(Model model) {
    model.addAttribute("boards", boardService.getBoardList());
    return "board/list";
  }
  
  @GetMapping("/board/write.do")
  public String write() {
    return "board/write";
  }
  
  @PostMapping("/board/add.do")
  public String add(BoardDto board, RedirectAttributes attr) {
    attr.addFlashAttribute("addResult", boardService.addBoard(board));
    return "redirect:/board/list.do";
  }
  
  @GetMapping("/board/detail.do")
  public String detail(int boardNo, Model model) {
    model.addAttribute("board", boardService.getBoardByNo(boardNo));
    return "board/detail";
  }
  
  @PostMapping("/board/edit.do")
  public String edit(int boardNo, Model model) {
    model.addAttribute("board", boardService.getBoardByNo(boardNo));
    return "board/edit";
  }
  
  @PostMapping("/board/modify.do")
  public String modify(BoardDto board, RedirectAttributes attr) {
    attr.addFlashAttribute("modifyResult", boardService.modifyBoard(board));
    return "redirect:/board/detail.do?boardNo=" + board.getBoardNo();
  }
  
  @PostMapping("/board/remove.do")
  public String remove(int boardNo, RedirectAttributes attr) {
    attr.addFlashAttribute("removeResult", boardService.removeBoard(boardNo));
    return "redirect:/board/list.do";
  }
  
  @PostMapping("/board/removeList.do")
  public String removeList(String[] boardNoList, RedirectAttributes attr) {
    attr.addFlashAttribute("removeListResult", boardService.removeBoardList(boardNoList));
    return "redirect:/board/list.do";
  }
  
}
