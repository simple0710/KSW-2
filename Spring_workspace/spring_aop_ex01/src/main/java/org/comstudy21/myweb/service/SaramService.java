package org.comstudy21.myweb.service;

import java.util.List;

import org.comstudy21.myweb.model.SaramDTO;

public interface SaramService {
	// Service 인터페이스를 구현하는 클래스를 만든다.
	
	List<SaramDTO> selectAll();

	SaramDTO selectOne(SaramDTO dto);

	void insert(SaramDTO dto);

	void update(SaramDTO dto);

	void delete(SaramDTO dto);
}