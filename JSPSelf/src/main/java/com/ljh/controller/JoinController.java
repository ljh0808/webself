package com.ljh.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljh.dao.JoinDAO;
import com.ljh.dto.JoinDTO;

@WebServlet("/enter/join")
public class JoinController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		boolean a = false;
		
		JoinDTO dto = new JoinDTO(id,pwd,name,email);
		
		try {
			
			a =JoinDAO.joinMember(dto);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(a) {
			System.out.println("a값 참");
		} else {
			System.out.println("a값 거짓");
		}
		
		
		
	}
}
