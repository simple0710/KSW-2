package org.comstudy.myapp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaramDTO {
	private int idx;
	private String id;
	private String name;
	private int age;
}

// 스프링 프로젝트 내보내기
// File > Export