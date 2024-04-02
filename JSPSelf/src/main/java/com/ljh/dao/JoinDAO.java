package com.ljh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ljh.dto.JoinDTO;
import com.ljh.DBManager;

public class JoinDAO {

	Connection con;
	PreparedStatement st;
	
	public  Boolean joinMember(JoinDTO dto) throws SQLException, ClassNotFoundException {
		
		String sql=null;
		String id =dto.getId();
		String pwd =dto.getPwd();
		String name =dto.getName();
		String email =dto.getEmail(); //dto에 저장된값 변수에저장
		
		sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
		con = DBManager.getConnection();
		System.out.println("DBCP 메서드 불러옴");
		
		try {
			System.out.println("연동성공");
			con.setAutoCommit(false); //오토커밋 off
			
			st = con.prepareStatement(sql);
			
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
			
			
			
			return true;
		}
		finally {	
		DBManager.close(con,st);
		}
	}
}
