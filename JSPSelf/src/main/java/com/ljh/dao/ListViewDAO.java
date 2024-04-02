package com.ljh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.ljh.DBManager;
import com.ljh.SqlD;
import com.ljh.dto.ListDTO;

public class ListViewDAO {
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	
	
	public  ArrayList<ListDTO> ListView(int num) throws SQLException {
//	String sql = "SELECT NO,TITLE,WRITER,DAY,COUNT,CONTENT FROM LIST WHERE NO="+num
//			+"ORDER BY DAY DESC";
		
//	String sql = "SELECT RNUM1,TITLE,WRITER,DAY,COUNT,CONTENT FROM "
//			+ "(SELECT ROWNUM RNUM1,TITLE,WRITER,DAY,COUNT,CONTENT FROM "
//			+ "(SELECT ROWNUM RNUM,TITLE,WRITER,DAY,COUNT,CONTENT FROM LIST ORDER BY DAY))"
//			+ "WHERE RNUM1="+num;
	
	String sql ="SELECT RNUM1,TITLE,WRITER,DAY,COUNT,CONTENT FROM NO_VIEW WHERE RNUM1="+num;
	
		try {
			con = DBManager.getConnection();
			
			System.out.println("연동성공 ListViewDAO");
			st = con.createStatement();
			rs = st.executeQuery(sql);
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
			
		}  finally {
			DBManager.close(con, st, rs);
		}
		
	
	}
	
	public void listcount(int num) throws SQLException {
		String sql = "UPDATE LIST SET COUNT = COUNT+1 WHERE NO=(SELECT NO FROM NO_VIEW WHERE RNUM1=?)";

		con = DriverManager.getConnection(SqlD.URL,SqlD.USERID,SqlD.USERPWD);
		ps = con.prepareStatement(sql);
		ps.setInt(1, num);
		ps.executeUpdate();
		System.out.println("조회수증가");
		
		
	}
}