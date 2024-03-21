package com.ljh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.ljh.dto.ListDTO;

public class ListViewDAO {
	
	public static ArrayList<ListDTO> ListView(int num) {
	String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
	String sql = "SELECT NO,TITLE,WRITER,DAY,COUNT,CONTENT FROM LIST WHERE NO="+num;
	
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"C##NEWLEC1","1234");
			System.out.println("연동성공 ListViewDAO");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
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