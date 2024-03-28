package com.ljh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.ljh.SqlD;
import com.ljh.dto.ListDTO;

public class ListViewDAO {
	
	public  ArrayList<ListDTO> ListView(int num) {
//	String sql = "SELECT NO,TITLE,WRITER,DAY,COUNT,CONTENT FROM LIST WHERE NO="+num
//			+"ORDER BY DAY DESC";
	String sql = "SELECT RNUM1,TITLE,WRITER,DAY,COUNT,CONTENT FROM "
			+ "(SELECT ROWNUM RNUM1,TITLE,WRITER,DAY,COUNT,CONTENT FROM "
			+ "(SELECT ROWNUM RNUM,TITLE,WRITER,DAY,COUNT,CONTENT FROM LIST ORDER BY DAY))"
			+ "WHERE RNUM1="+num;
	
		try {
			Class.forName(SqlD.DRIVER);
			Connection con = DriverManager.getConnection(SqlD.URL,SqlD.USERID,SqlD.USERPWD);

			System.out.println("연동성공 ListViewDAO");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			System.out.println("rs");
			ArrayList<ListDTO> list = new ArrayList<>();
			System.out.println("여기까지는 문제없음");
			
			while(rs.next()) {
				String no = rs.getString(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				Date day = rs.getDate(4);
				String count = rs.getString(5);
				String content = rs.getString(6);
				list.add(new ListDTO(no,title,writer,day,count,content));
				System.out.println("값 담기 성공");
				
			}
			return list;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL예외발생");
		} 
		return null;
	}
}