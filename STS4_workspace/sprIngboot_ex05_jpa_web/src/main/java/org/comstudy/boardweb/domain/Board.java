package org.comstudy.boardweb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "BOARD", uniqueConstraints = {@UniqueConstraint(columnNames = {"SEQ"})})
@Data
public class Board {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "SEQ")
	private Long seq;
	private String title;
	private String writer;
	private String content;
	private Date writeDate = new Date();
	private Long cnt = 0L;
}
