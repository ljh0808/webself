package com.ljh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ljh.dto.ListAddDTO;


public class ListAddDAO {
	public static void Addlist(ListAddDTO dto) {
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		String sql = "INSERT INTO LIST(TITLE,CONTENT) VALUES(?,?)";
		String title = dto.getTitle();
		String content = dto.getContent();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"C##NEWLEC1","1234");
			System.out.println("게시판 작성연동성공");
			con.setAutoCommit(false);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,title);
			st.setString(2,content);
			
			st.executeUpdate(); //
			con.commit();
			
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
}
}
