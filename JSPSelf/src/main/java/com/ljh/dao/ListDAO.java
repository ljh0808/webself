package com.ljh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.ljh.SqlD;
import com.ljh.dto.ListDTO;

public class ListDAO {
	Connection con;
	Statement st;
	ResultSet rs;
	public  ArrayList<ListDTO> getList() throws SQLException {
//		"SELECT ROWNUM,TITLE,WRITER,DAY,COUNT FROM(SELECT ROWNUM,NO,TITLE,WRITER,DAY,COUNT ORDER BY DAY) ORDER BY ROWNUM DESC"

//		String sql = "SELECT ROWNUM,TITLE,WRITER,DAY,COUNT FROM"
//				+ "(SELECT ROWNUM,TITLE,WRITER,DAY,COUNT FROM LIST ORDER BY DAY) "
//				+ "ORDER BY ROWNUM DESC";
		String sql="SELECT RNUM1,TITLE,WRITER,DAY,COUNT FROM NO_VIEW ORDER BY RNUM1 DESC";
		
		try {
			Class.forName(SqlD.DRIVER);
			con = DriverManager.getConnection(SqlD.URL,SqlD.USERID,SqlD.USERPWD);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			ArrayList<ListDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				String no = rs.getString(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				Date day = rs.getDate(4);
				String count = rs.getString(5);
				list.add(new ListDTO(no,title,writer,day,count));

			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {rs.close();}
			if(st!=null) {st.close();}
			if(con!=null) {con.close();}
		}
		return null;
	}
	
	
	public  void updateList(ListDTO dto) throws SQLException{
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		String sql = "UPDATE LIST SET TITLE=?,CONTENT=? WHERE "
				+ "NO=(SELECT NO FROM(SELECT ROWNUM RNUM1,NO FROM(SELECT ROWNUM,NO FROM LIST ORDER BY DAY)) WHERE RNUM1=?)";
		
		try {
			Class.forName(SqlD.DRIVER);
			Connection con = DriverManager.getConnection(url,SqlD.USERID,SqlD.USERPWD);
			System.out.println("연동성공");
			PreparedStatement st = con.prepareStatement(sql);
			con.setAutoCommit(false);
			st.setString(1, dto.getTitle());
			st.setString(2, dto.getContent());
			st.setString(3, dto.getNo());
			int a = st.executeUpdate();
			if(a>0) {
				con.commit();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(st!=null) {st.close();}
			if(con!=null) {con.close();}
		}
		
	}
	
}

