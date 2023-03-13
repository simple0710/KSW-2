package org.comstudy.todo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TODO")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TodoEntity {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String no; // 오브젝트 아이디
	private String userId;
	private String title;
	private boolean done;
}
