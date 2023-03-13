package org.comstudy.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TodoDTO {
	private String id;
	private String userId;
	private String title;
	private boolean done;
}
