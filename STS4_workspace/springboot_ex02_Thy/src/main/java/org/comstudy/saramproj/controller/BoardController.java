package org.comstudy.saramproj.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class BoardController {
	@GetMapping("/getBaordList")
	public String getBoardList() {
		return "getBoardList";
	}
}
