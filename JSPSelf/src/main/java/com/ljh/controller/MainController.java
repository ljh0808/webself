package com.ljh.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljh.dao.MainDAO;
import com.ljh.dto.MainDTO;
 
@WebServlet("/enter/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1321321L;
	HttpSession hs;  
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		String id = request.getParameter("id");  
		String pwd = request.getParameter("pwd"); //입력값 저장
		hs = request.getSession();   //세션생성
		MainDTO dto =  new MainDTO(id,pwd); // 생성자이용  dto에 값저장
		
		try {
			MainDAO.mainEnter(dto);    //DAO에있는 메서드이용
			if(MainDAO.MainCheck(dto)) {
				System.out.println("아이디 비밀번호 일치");
				hs.setAttribute("id", id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/loginOk.jsp");
				dispatcher.forward(request, response);
			}
			else {
				System.out.println("아이디 비밀번호 불일치");
				String msg = "아이디 또는 비밀번호가 일치하지 않습니다.";
				hs.setAttribute("msg", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/sublogin.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	
}
