package org.comstudy.boardweb;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.comstudy.boardweb.entity.Board;
import org.comstudy.boardweb.entity.Member;
import org.comstudy.boardweb.persistence.BoardRepository;
import org.comstudy.boardweb.persistence.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class RelationMappingTest {
	@Autowired
	private BoardRepository boardRepo;
	@Autowired
	private MemberRepository memberRepo;
	
	@Test
	void testManyToOneJoin() {
		// 참조 엔티티가 영속성 영역에 먼저 들어가야 한다.
		Member member = new Member();
		member.setId("mem01");
		member.setName("범준샘");
		member.setPassword("12345");
		member.setRole("User");
		memberRepo.save(member);
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			board.setMember(member);
			board.setTitle("범준샘이 등록한 게시글 제목" + i);
			board.setContent("범준샘이 등록한 게시글 내용" + i);
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardRepo.save(board);
		}
	}
	
	
	@Test
	void test() {
		log.info("test():voie - RelationMappingTest 실행 테스트");
		System.out.println(">>>>> test():voie - RelationMappingTest 실행 테스트");
	}

}
