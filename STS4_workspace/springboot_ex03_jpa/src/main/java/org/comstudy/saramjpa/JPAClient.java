package org.comstudy.saramjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.comstudy.saramjpa.domain.SaramEntity;

public class JPAClient {

   public static void main(String[] args) {
      // EntityManager로 JPA 사용 하는것은 애플리케이션(응용프로그램)으로 실행 한다.
      // EntityManager는 EntityManagerFactory에서 만들어 준다.
      // CRDU 기능의 SQL 적용하기 위해 EntityTranjection이 필요하다.
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("SaramJPA");
      EntityManager em = emf.createEntityManager();
      EntityTransaction tx = em.getTransaction();
      try {
         tx.begin();
         // tx.begin()과 tx.commit() 사이에 CRUD 구문이 위치해야 한다.
         SaramEntity saram = new SaramEntity();
         saram.setId("HONG");
         saram.setName("홍길동");
         saram.setAge(25);
         em.persist(saram);
         
         SaramEntity searchSaram = em.find(SaramEntity.class, 1L);
         System.out.println("Saram 검색 결과 : " + searchSaram.toString());
         
         tx.commit();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         em.close();
         emf.close();
      }
   }

}