package com.goodee.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goodee.app.dto.BoardDto;
import com.goodee.app.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {

   private final BoardService boardService;

   @RequestMapping("/list.do")
   public String list(HttpServletRequest request, Model model) {
     boardService.loadBoardList(request, model);
     return "board/list";
   }
   
   @PostMapping("/add.do")
   public String add(BoardDto board, RedirectAttributes attr) {
   int addResult = boardService.addBoard(board);
   attr.addFlashAttribute("addResult", addResult);
   return "redirect:/list.do";
   
}
   
}
