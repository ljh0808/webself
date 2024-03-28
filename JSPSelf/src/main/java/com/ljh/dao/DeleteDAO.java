package com.ljh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ljh.SqlD;

public class DeleteDAO {
	
	public void deletelist(int num) {
		
		String sql1 = "SELECT NO FROM(SELECT ROWNUM RNUM1,NO FROM(SELECT ROWNUM,NO FROM LIST ORDER BY DAY))"
				+ "WHERE RNUM1="+num;
		String sql2="DELETE LIST WHERE NO=?";
	
		try {
			Class.forName(SqlD.DRIVER);
			Connection con = DriverManager.getConnection(SqlD.URL,SqlD.USERID,SqlD.USERPWD);
			System.out.println("delete 연동");
			con.setAutoCommit(false); //오토커밋 off
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery(sql1);
			int a = 0;
			while(rs1.next()) {
				a=rs1.getInt(1);
			}
			System.out.println(a+"a의값");
			
			PreparedStatement st2 = con.prepareStatement(sql2);
			System.out.println("st2실행");
			st2.setInt(1,a);
			System.out.println("st2.steInt실행");
			st2.executeUpdate();
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
