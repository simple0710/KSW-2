package org.comstudy.myapp;

import org.comstudy.myapp.model.SaramDTO;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class main {
	// Run As > Run on Server 실행 : 웹 서버 어플리케이션 실행
	// Run As > Java Application 실행 : main()에서 실행 되는 Application
	public static void main(String[] args) {
		// 웹에서 실행 되지 않음.
		System.out.println("Hello Spring World!");

		// 직접 빈 객체를 생성해서 사용
//		SaramDTO saramDTO = new SaramDTO(11, "KIM", "김유신", 35);
//		System.out.println(saramDTO);
		
		// applicationContext.xml에 선언된 Bean 객체 Lookup
		String resource = "applicationContext.xml";
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext(resource);
		SaramDTO dto = (SaramDTO)factory.getBean("saramDTO"); // 오브젝트를 리턴한다.
		System.out.println(dto);
	}
}
