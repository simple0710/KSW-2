package org.comstudy.boardweb.service;

import java.util.List;

import org.comstudy.boardweb.domain.Board;
import org.comstudy.boardweb.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	public void persist(Board board) {
		boardRepository.save(board);
	}
	
	public List<Board> selectAll() {
		return (List)boardRepository.findAll();
	}
}
