package com.ljh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ljh.dto.JoinDTO;


public class JoinDAO {
	public static String url;
	public static String sql;
	
	
	public static Boolean joinMember(JoinDTO dto) throws ClassNotFoundException,SQLException {
		
		String id =dto.getId();
		String pwd =dto.getPwd();
		String name =dto.getName();
		String email =dto.getEmail();
		
		url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection(url,"C##NEWLEC1","1234");
		System.out.println("연결성공");
		con.setAutoCommit(false);
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);
		st.setString(2, pwd);
		st.setString(3, name);
		st.setString(4, email);
		st.executeUpdate();
		con.commit();
		
		System.out.println("데이터입력 성공");
		
		
		
		
		return true;
	}
}
