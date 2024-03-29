package com.ljh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ljh.SqlD;

public class DeleteDAO {
	Connection con;
	Statement st1;
	ResultSet rs1;
	PreparedStatement st2;
	
	public void deletelist(int num) throws SQLException {
		
		String sql1 = "SELECT NO FROM(SELECT ROWNUM RNUM1,NO FROM(SELECT ROWNUM,NO FROM LIST ORDER BY DAY))"
				+ "WHERE RNUM1="+num;
		String sql2="DELETE LIST WHERE NO=?";
	
		
		try {
			Class.forName(SqlD.DRIVER);
			con = DriverManager.getConnection(SqlD.URL,SqlD.USERID,SqlD.USERPWD);
			System.out.println("delete 연동");
			con.setAutoCommit(false); //오토커밋 off
			st1 = con.createStatement();
			rs1 = st1.executeQuery(sql1);
			int a = 0;
			while(rs1.next()) {
				a=rs1.getInt(1);
			}
			
			System.out.println(a+"a의값");
			
			st2 = con.prepareStatement(sql2);
			System.out.println("st2실행");
			st2.setInt(1,a);
			System.out.println("st2.steInt실행");
			st2.executeUpdate();
			con.commit(); 
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs1!=null) {rs1.close();}
			if(st2!=null) {st2.close();}
			if(st1!=null) {st1.close();}
			if(con!=null) {con.close();}
		}
		
	}
}
