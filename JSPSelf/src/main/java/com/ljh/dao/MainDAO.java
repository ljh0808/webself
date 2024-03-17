package com.ljh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ljh.dto.MainDTO;

public class MainDAO {
	public static String id = null;
	public static String pwd = null;
	public static PreparedStatement st;
	public static ResultSet rs;
	public static Connection con;
	
	//db접속
	public static void  mainEnter(MainDTO dto) throws SQLException,ClassNotFoundException{
		String url="jdbc:oracle:thin:@localhost:1521:xe?useUnicode=true&characterEncoding=utf8";
		String sql="SELECT ID,PWD FROM MEMBER WHERE ID=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,"C##NEWLEC1","1234");
			
			st=con.prepareStatement(sql);
			st.setString(1, dto.getId());
			System.out.println("메인DAO접근");
			rs=st.executeQuery();  //select문 실행
	
			while(rs.next()) {
				id = rs.getString(1);
				pwd = rs.getString(2);
			}
		}
		finally {
			if(rs!=null) { rs.close();}
			if(st!=null) {st.close();}
			if(con!=null) {con.close();}  //db종료
		}
	}

	//입력값 db값 비교
	public static boolean MainCheck(MainDTO dto) {
		if(id==null|| pwd==null) {
			return false;
		} else if((id.equals(dto.getId()) && pwd.equals(dto.getPwd()))) {
			return true;
		} else {
			return false;
		}
	}
}

