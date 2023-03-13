package org.comstudy.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestRequestBodyDTO {
	private int id;
	private String message;
}
