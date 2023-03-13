package org.comstudy.todo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.comstudy.todo.domain.TodoEntity;
import org.comstudy.todo.dto.ResponseDTO;
import org.comstudy.todo.dto.TodoDTO;
import org.comstudy.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*") // React프로젝트에서 포트번호가 다른 문제 해결
@RestController
@RequestMapping("/todo")
public class TodoController {
	@Autowired
	TodoService service;
	
	String temporaryUserId = "temporary-user";
	
	// 입력 기능
	@PostMapping
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto) {
		try {
			// 1. Entity로 변환
			TodoEntity entity = dto.toEntity();
			// 2. entity의 id는 생성시 null이어 한다.(테이블에 insert될때 Generator로 자동 생성)
			entity.setNo(null);
			// 3. 임시 UserId 사용
			entity.setUserId(temporaryUserId);
			// 4. serivice를 이용해서 Entity List 생성
			List<TodoEntity> entitis = service.create(entity);
			// 5. TodoEntity 리스틀 TodoDTO 리스트로 변환.
			List<TodoDTO> dtos = entitis.stream().map(TodoDTO::new).collect(Collectors.toList());
			// 6. TodoDTO 리스트를 ResponseDTO로 초기화
			ResponseDTO<TodoDTO> response = ResponseDTO
					.<TodoDTO>builder().data(dtos).build();
			// 7. ResponseDTO 를 리턴한다.
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			// 예외 발생 시 처리
			String error = e.getMessage();
			ResponseDTO<TodoDTO> response = ResponseDTO
					.<TodoDTO>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	// 검색
	@GetMapping("/findList")
	public ResponseEntity<?> findTodoList(@RequestBody TodoDTO dto) {
		try {
			List<TodoEntity> entitis = service.retrieve(dto.getUserId());
			List<TodoDTO> todos = entitis.stream().map(TodoDTO::new).collect(Collectors.toList());
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(todos).build();
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			ResponseDTO<TodoDTO> response = 
					ResponseDTO.<TodoDTO>builder().error(">>> 검색 에러: " + e.getMessage()).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
	@GetMapping
	public ResponseEntity<?> findTodoList() {
		try {
			List<TodoEntity> entitis = service.retrieve("");
			List<TodoDTO> todos = entitis.stream().map(TodoDTO::new).collect(Collectors.toList());
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(todos).build();
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			ResponseDTO<TodoDTO> response = 
					ResponseDTO.<TodoDTO>builder().error(">>> 검색 에러: " + e.getMessage()).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	// 수정
	@PutMapping
	public ResponseEntity<?> updateTodo(@RequestBody TodoDTO dto) {
		try {
			// 1. dto로 변환
			TodoEntity entity = dto.toEntity();
			// 2. id 초기화
			entity.setUserId(temporaryUserId);
			// 3. entity로 업데이트
			List<TodoEntity> entitis = service.update(entity);
			// 4. Entity리스트를 Todo 리스트로 변환
			List<TodoDTO> todos = entitis.stream().map(TodoDTO::new).collect(Collectors.toList());
			// 5. ResponseDTO 초기화
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(todos).build();
			// 6. ResponseDTO 리턴
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			ResponseDTO<TodoDTO> response = 
					ResponseDTO.<TodoDTO>builder().error(">>> 수정 에러: " + e.getMessage()).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	// 삭제
	@DeleteMapping
	public ResponseEntity<?> deleteTodo(@RequestBody TodoDTO dto) {
		try {
			TodoEntity entity = dto.toEntity();
			// 2. id 초기화
			entity.setUserId(temporaryUserId);
			// 3. entity로 업데이트
			List<TodoEntity> entitis = service.delete(entity);
			ResponseDTO<TodoEntity> response = ResponseDTO.<TodoEntity>builder().data(entitis).build();
			// 6. ResponseDTO 리턴
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			ResponseDTO<TodoEntity> response = ResponseDTO.<TodoEntity>builder().error("삭제 에러!").build();
			return ResponseEntity.ok().body(response);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<?> selectAll() {
		try {
			List<TodoEntity> entitis = service.findAll();
			List<TodoDTO> todos = entitis.stream().map(TodoDTO::new).collect(Collectors.toList());
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(todos).build();
			return ResponseEntity.ok().body(response);
		}catch (Exception e) {
			ResponseDTO<TodoDTO> response = 
					ResponseDTO.<TodoDTO>builder().error(">>> Select All 에러: " + e.getMessage()).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
}
