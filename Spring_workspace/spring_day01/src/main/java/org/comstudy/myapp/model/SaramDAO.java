package org.comstudy.myapp.model;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

// 클래스 선언 및 빈 등록
@Repository
public class SaramDAO {
	public ArrayList<SaramDTO> selectAll() {
		System.out.println("selectAll() 호출 됨!");
		return null;
	}
}
