package org.comstudy.todo.dto;

import org.comstudy.todo.domain.TodoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TodoDTO {
	private String id; // 오브젝트 아이디
	private String userId;
	private String title;
	private boolean done;

	// Entity ===> DTO로 변경
	public TodoDTO(final TodoEntity entity) {
		this.id = entity.getId();
		this.userId = entity.getUserId();
		this.title = entity.getTitle();
		this.done = entity.isDone();
	}

	// DTO ===> Entity로 변경
	public static TodoEntity toEntity(final TodoDTO dto) {
		return TodoEntity.builder().id(dto.getId()).title(dto.getTitle()).done(dto.isDone()).build();
	}

	public TodoEntity toEntity() {
		return TodoEntity.builder().id(id).title(title).done(done).build();
	}
}