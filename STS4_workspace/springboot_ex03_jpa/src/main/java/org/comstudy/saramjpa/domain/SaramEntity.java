package org.comstudy.saramjpa.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SARAM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaramEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long seq;
	private String id;
	private String name;
	private int age;
}
