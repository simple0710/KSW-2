package org.comstudy.boardweb.controller;

import java.util.List;

import org.comstudy.boardweb.domain.Board;
import org.comstudy.boardweb.persistence.BoardRepository;
import org.comstudy.boardweb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	BoardService boardService = new BoardService();
	
	@GetMapping("/board/list")
	public String boardList(Model model) {
		List<Board> list = boardService.selectAll();
		System.out.println(list);
		log.info("list -> " + list.toString());
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@GetMapping("/board/input")
	public String boardInput() {
		return "board/input";
	}
	
	@PostMapping("/board/input")
	public String boardInputProc(Board board) {
		boardService.persist(board);
		return "redirect:/board/list";
	}
}
