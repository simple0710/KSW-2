package org.comstudy.todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.comstudy.todo.dto.ResponseDTO;
import org.comstudy.todo.dto.TestRequestBodyDTO;
import org.comstudy.todo.service.TodoService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@Autowired
	TodoService todoService;
	
	@GetMapping("/todo/test")
	public String todoTest() {
		
		return todoService.testService();
	}
	
	@GetMapping("/")
	public String hello() {
		// @RestController를 사용하면
		// 리턴되는 문자열이 브라우저에 바로 출력 된다.
		return "{\"message\":\"Hello Comstudy Schools\"}";
	}
	
	@PostMapping("/hello")
	public String helloProc(
			@RequestParam("user") 
			String user, 
			@RequestParam("message") 
			String message) {
		return String.format("{\"user\":\"%s\",\"message\":\"%s\"}", user, message);
	}
	
	@GetMapping("/saram/{id}/{message}")
	public String pathVariables(
			@PathVariable(required = true) String id, 
			@PathVariable String message) {
		// JSONObject 라이브러리 활용;
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("no", 1);
		jsonObj.put("id", id);
		jsonObj.put("message", message);
		return jsonObj.toString(2);
	}
	
	@GetMapping("/requestBody")
	public String testRequestBody(@RequestBody TestRequestBodyDTO reqDTO) {
		return reqDTO.toString();
	}
	
	@GetMapping("/requestBody2")
	public TestRequestBodyDTO testRequestBody2(@RequestBody TestRequestBodyDTO reqDTO) {
		return reqDTO;
	}
	
	@GetMapping("/responseBody")
	public ResponseDTO<String> responseBody() {
		List<String> list = new ArrayList();
		list.add("Hello SpringBoot world");
		ResponseDTO<String> response = ResponseDTO.<String>builder().error("200").data(list).build();
		return response;
	}
	
	@GetMapping("/responseEntity")
	public ResponseEntity<?> responseEntity() {
		List<String> list = new ArrayList<String>();
		list.add("Hello World! I'm ResponseEntity. And you got 400!");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		
		// http status 400
		return ResponseEntity.badRequest().body(response);
		
		// http status 200
		//return ResponseEntity.ok().body(response);
	}
	
}
