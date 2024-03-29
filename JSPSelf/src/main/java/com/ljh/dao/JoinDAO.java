package com.ljh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ljh.SqlD;
import com.ljh.dto.JoinDTO;


public class JoinDAO {

	Connection con;
	PreparedStatement st;
	
	public  Boolean joinMember(JoinDTO dto) throws SQLException {
		
		String sql=null;
		String id =dto.getId();
		String pwd =dto.getPwd();
		String name =dto.getName();
		String email =dto.getEmail(); //dto에 저장된값 변수에저장
		
		sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
		try {
			Class.forName(SqlD.DRIVER);
			con = DriverManager.getConnection(SqlD.URL,SqlD.USERID,SqlD.USERPWD);
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
		if(st!=null) {st.close();}
		if(con!=null) {con.close();}
		} return false;
	}
}
