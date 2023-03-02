package org.comstudy.myweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.myweb.board.model.BoardDTO;

public class BoardController implements Controller {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
		boardList.add(new BoardDTO(1L, "연습글", "게시글 등록 연습입니다.", new Date(), "홍길동", 0L));
		boardList.add(new BoardDTO(2L, "연습글2", "게시글 등록 연습입니다2", new Date(), "김길동", 0L));
		
		req.setAttribute("boardList", boardList);
		
		String viewName = "/WEB-INF/views/board/list.jsp";
				
		return viewName;
	}

}
