package org.comstudy.myweb.saram.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SaramDAO {
   
   SqlSession session;
   
   public SaramDAO() {
      try {
         String resource = "org/comstudy/ex05/mybatis-config.xml";
         InputStream inputStream = Resources.getResourceAsStream(resource);
         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

         session = sqlSessionFactory.openSession();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public List<SaramDTO> findAll() {
      List<SaramDTO> list = session.selectList("org.comstudy.ex05.SaramMapper.findAll");
      return list;
   }

   public SaramDTO findOne(SaramDTO dto) {
      SaramDTO saram = session.selectOne("org.comstudy.ex05.SaramMapper.findOne", dto.getSeq());
      return saram;
   }

   // 입력
   public void save(SaramDTO dto) {
      
   }

   // 수정
   public void update(SaramDTO dto) {
      
   }

   // 삭제
   public void remove(SaramDTO dto) {
      
   }
   
   
   // --- TEST ---
   static SaramDAO dao = new SaramDAO();
   public static void main(String[] args) {
      //SaramDTO saram = dao.findOne( new SaramDTO(6, null, null, 0));
      //System.out.println(saram);
      
      List<SaramDTO> list = dao.findAll();
      System.out.println(list);
   }
}