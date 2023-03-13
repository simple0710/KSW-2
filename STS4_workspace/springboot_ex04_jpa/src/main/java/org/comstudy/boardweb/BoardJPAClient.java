package org.comstudy.boardweb;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.comstudy.boardweb.domain.BoardEntity;

public class BoardJPAClient {

   public static void main(String[] args) {
      //1. EntityManagerFactory
      //2. EntityManager
      //3. EntityTranjection
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("BoardWeb");
      EntityManager em = emf.createEntityManager();
      EntityTransaction tx = em.getTransaction();
      
      try {
         tx.begin();
         
         for(int i=0; i<10; i++) {
            BoardEntity board = new BoardEntity();
            board.setTitle("글씨기 제목" + i);
            board.setContent("게시 글 내용 ..." + i);
            board.setWriter("관리자");
            em.persist(board);
         }
         
         // 검색
         BoardEntity board = em.find(BoardEntity.class, 3L);
         System.out.println(board);
         
		/*
		 * // 삭제 em.remove(board);
		 */
         
         tx.commit();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         em.close();
         emf.close();
      }
   }
}