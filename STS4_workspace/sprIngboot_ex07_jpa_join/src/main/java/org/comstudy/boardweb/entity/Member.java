package org.comstudy.boardweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "boardList")
public class Member {
	@Id
	private String id;
	private String password;
	private String name;
	private String role;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Board> boardList = new ArrayList();
}
