package org.comstudy.todo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestRequestBodyDTO {
	private int id;
	private String message;
}
