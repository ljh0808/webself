package com.ljh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ljh.dto.JoinDTO;


public class JoinDAO {
	public static String url;
	public static String sql;
	
	
	public static Boolean joinMember(JoinDTO dto) throws ClassNotFoundException,SQLException {
		
		String id =dto.getId();
		String pwd =dto.getPwd();
		String name =dto.getName();
		String email =dto.getEmail(); //dto에 저장된값 변수에저장
		
		url = "jdbc:oracle:thin:@localhost:1521:xe?useUnicode=true&characterEncoding=utf8";
		sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection(url,"C##NEWLEC1","1234");
		System.out.println("연동성공");
		con.setAutoCommit(false); //오토커밋 off
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);
		st.setString(2, pwd);
		st.setString(3, name);
		st.setString(4, email);
		if(st.executeUpdate()>0) {  
		con.commit(); }
		else {
			System.out.println("회원가입 실패");
		}
		
		System.out.println("데이터입력");
		
		if(st!=null) {st.close();}
		if(con!=null) {con.close();}
		
		
		return true;
	}
}
