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

import com.ljh.dao.JoinDAO;
import com.ljh.dto.JoinDTO;

@WebServlet("/enter/join")
public class JoinController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id =request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		boolean a = false;
		
		JoinDTO dto = new JoinDTO(id,pwd,name,email); //회원가입 입력값 DTO에저장
		
		try {
			
			a =JoinDAO.joinMember(dto); //JoinDAO메서드 이용 T,F값 변수a에 저장
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(a) {
			
			System.out.println("회원가입 성공");
			HttpSession hs = request.getSession();
			hs.setAttribute("name", name);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Hello.jsp");
			dispatcher.forward(request, response); //참일시 세션name저장후 환영jsp 및 환영문구 출력
		} else {
			System.out.println("회원가입 실패"); //회원가입실패 (추가사항 필요)
		}
		
		
		
	}
}
