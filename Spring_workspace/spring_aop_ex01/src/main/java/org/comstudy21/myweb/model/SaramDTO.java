package org.comstudy21.myweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaramDTO {
	private Long seq;
	private String id;
	private String name;
	private Long age;
}
