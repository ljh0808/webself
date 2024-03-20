package com.ljh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljh.dao.ListAddDAO;
import com.ljh.dao.ListDAO;
import com.ljh.dto.ListAddDTO;
import com.ljh.dto.ListDTO;

@WebServlet("/ListAddController")
public class ListAddController extends HttpServlet {
	private static final long serialVersionUID = 14124141L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		ListAddDTO dto = new ListAddDTO(title,content);
		ListAddDAO.Addlist(dto);
		System.out.println(dto.getContent());
		System.out.println(dto.getTitle());
		ArrayList<ListDTO> list = ListDAO.getList();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/boardlist.jsp");
		dispatcher.forward(request, response);
		
	}

}
