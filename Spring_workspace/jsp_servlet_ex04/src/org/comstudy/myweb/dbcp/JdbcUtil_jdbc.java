package org.comstudy.myweb.dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil_jdbc {
	
	public static Connection getConnection() {
		// JDBC 연동 - 커넥션 드라이버 찾기
		String url="jdbc:h2:tcp://localhost/~/test";
		String user="sa";
		String password="";
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver"); // 드라이버 검색 -> 인스턴스화
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL 오류!");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection obj) {
		try {
			if(obj != null) obj.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet obj) {
		try {
			if(obj != null) obj.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement obj) {
		try {
			if(obj != null) obj.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// static 멤버 = class 멤버 : 클래스 외부에서 객체 생성 없이 클래명으로 접근 가능.
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		close(rs);
		close(stmt);
		close(conn);
	}
}
