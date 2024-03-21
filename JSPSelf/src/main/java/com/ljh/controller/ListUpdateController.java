package com.ljh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljh.dao.ListDAO;
import com.ljh.dto.ListDTO;

@WebServlet("/ListUpdateController")
public class ListUpdateController extends HttpServlet {
	private static final long serialVersionUID = 153427L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("no");
		String title =request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(num);
		ListDTO dto = new ListDTO(num,title,content);
		ListDAO.updateList(dto);
		response.sendRedirect("main.jsp");
	}

}
