package com.ljh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.ljh.SqlD;
import com.ljh.dto.ListDTO;

public class ListAddDAO {
	Connection con = null;
	PreparedStatement st = null;
	public void Addlist(ListDTO dto) throws SQLException {
		String sql = "INSERT INTO LIST(NO,TITLE,WRITER,COUNT,CONTENT) VALUES(LIST_SEQ.NEXTVAL,?,?,0,?)";
		
		
		String title = dto.getTitle();
		String writer = dto.getWriter();
		String content = dto.getContent();
		try {
			Class.forName(SqlD.DRIVER);
			con = DriverManager.getConnection(SqlD.URL,SqlD.USERID,SqlD.USERPWD);
			System.out.println("게시판 작성연동성공");
			con.setAutoCommit(false);
			st = con.prepareStatement(sql);
			
			st.setString(1,title);
			st.setString(2,writer);
			st.setString(3,content);
			
			st.executeUpdate(); //
			con.commit();
			}
			
		 catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(st!=null) {st.close();}
			if(con!=null) {con.close();}
		}
		
	
}
}
