package org.comstudy.saramproj.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
	
	@GetMapping("/")
	public String index() {
		// 타임리프를 사용하면 src/main/resources의 template가 뷰 기본 폴더이다.
		return "index";
	}

}
