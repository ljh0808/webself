package com.ljh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.ljh.SqlD;
import com.ljh.dto.ListDTO;

public class ListAddDAO {
	public void Addlist(ListDTO dto) {
		Connection con = null;
		PreparedStatement st = null;
		String sql = "INSERT INTO LIST(no,title,writer,count,content) VALUES(LIST_SEQ.NEXTVAL,?,?,?,?)";
		
		
		String title = dto.getTitle();
		String count = dto.getCount();
		String content = dto.getContent();
		try {
			Class.forName(SqlD.DRIVER);
			con = DriverManager.getConnection(SqlD.URL,SqlD.USERID,SqlD.USERPWD);
			System.out.println("게시판 작성연동성공");
			con.setAutoCommit(false);
			st = con.prepareStatement(sql);
			
			st.setString(1,title);
			st.setString(2,dto.getWriter());
			st.setString(3,count);
			st.setString(4,content);
			
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
