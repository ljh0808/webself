package com.ljh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljh.dao.ListViewDAO;
import com.ljh.dto.ListDTO;

@WebServlet("/ListViewController")
public class ListViewController extends HttpServlet {
	private static final long serialVersionUID = 132134L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("no"));
		System.out.println(num);
		ArrayList<ListDTO> list = ListViewDAO.ListView(num);
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listView.jsp");
		dispatcher.forward(request, response);	
		System.out.println("값전달 성공");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
