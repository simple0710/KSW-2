package org.comstudy.todo.service;

import java.util.List;

import org.comstudy.todo.domain.TodoEntity;
import org.comstudy.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TodoService {
   @Autowired
   private TodoRepository repository;
   
   public String testService() {
      TodoEntity todoEntity = TodoEntity.builder().title("저녁 먹고 스터디 하기").build();
      repository.save(todoEntity);
      System.out.println();
      log.info(todoEntity.getId());
      TodoEntity savedEntity = repository.findById(todoEntity.getId()).get();
      return savedEntity.toString();
   }
   
   public List<TodoEntity> findAll() {
	   return repository.findAll();
   }
}