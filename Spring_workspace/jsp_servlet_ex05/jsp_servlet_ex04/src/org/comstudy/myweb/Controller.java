package org.comstudy.myweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	// 인터페이스를 상속받는 클래스는 인터페이스의 모든 추상 메소드를 구현 해야한다.
	// 이 인터페이스를 상속받는 클래스는 반드시 process를 구현해야 한다.
	String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}