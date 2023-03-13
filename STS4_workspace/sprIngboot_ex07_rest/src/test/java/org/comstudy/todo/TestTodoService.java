package org.comstudy.todo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.comstudy.todo.domain.TodoEntity;
import org.comstudy.todo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class TestTodoService {
   @Autowired
   TodoService todoService;

   @Test
   void test() {
      TodoEntity todo = new TodoEntity("t0001", "ADMIN", "놀기", false);
      List<TodoEntity> list = todoService.create(todo);
      System.out.println(list);
   }
}