package com.ljh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//DBCP: DataBase Connection Pool - connection을 일정 개수 미리 만들어 두고 웹 서버가 db에 접근이 필요할 때 마다 하나씩 빌리고 반납하는 방식으로 처리하여 위 문제를 해결한다.
public class DBManager {
	
	//db연결
	 public static Connection getConnection() {
		 Connection con=null;
		 try {
			//1. InitialContext 객체 생성: 톰켓 서버에서 자원을 찾는 InitialContext  
			Context initContext=new InitialContext();
			//2. 컨텍스트 객체의 lookup 메소드로 JNDI에 등록되있는 서버 자원을 찾음 DataSource ds = (DataSource) initialContext.lookup('java:/comp/env/jdbc/myoracle'); 과 동일
			Context envContext=(Context)initContext.lookup("java:comp/env");
			DataSource ds=(DataSource)envContext.lookup("jdbc/oracle");
			//3. lookup 메소드로 얻어낸 DataSource 객체로 getConnection()메소드를 호출하여 커넥션 객체를 얻어냄
			con=ds.getConnection();
			System.out.println("커넥션풀 db연동");
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return con;
	 }
	 
	 //select 수행 후 리소스 해제를 위한 메소드
	 public static void close(Connection con,Statement stmt, ResultSet rs) {
		
			 try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	 }
	 public static void close(Connection con,Statement stmt1,Statement stmt2, ResultSet rs) {
		 
		 try {
			 rs.close();
			 stmt1.close();
			 stmt2.close();
			 con.close();
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 
	 }
	 
	 //insert, update, delete 작업을 수행한 후 리소스 해제를 위한 메소드
	 public static void close(Connection con, Statement stmt) {
		
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
}

	 
}
