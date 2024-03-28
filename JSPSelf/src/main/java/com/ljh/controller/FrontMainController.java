package com.ljh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.DeleteCommand;
import command.EnterCommand;
import command.JoinCommand;
import command.ListAddCommand;
import command.ListCommand;
import command.ListUpdateCommand;
import command.ListViewCommand;
import command.LogOutCommand;

@WebServlet("*.do")
public class FrontMainController extends HttpServlet {
	private static final long serialVersionUID = 179546L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doaction(request,response);
	}
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doaction(request,response);
 }
	protected void doaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String com = request.getRequestURI();
		String viewpage = null;
		Command command = null;
		
		switch(com) {
		case "/enter.do" :
			command = new EnterCommand();
			command.execute(request, response);
			viewpage= (String)request.getAttribute("viewpage");
			break;
		case "/join.do" :
			command = new JoinCommand();
			command.execute(request, response);
			viewpage = (String)request.getAttribute("viewpage");
			break;
		case "/list.do" :
			command = new ListCommand();
			command.execute(request, response);
			viewpage = (String)request.getAttribute("viewpage");
			break;
		case "/ListView.do" :
			command = new ListViewCommand();
			command.execute(request, response);
			viewpage = (String)request.getAttribute("viewpage");
			break;
		case "/ListAdd.do" :
			command = new ListAddCommand();
			command.execute(request, response);
			viewpage = (String)request.getAttribute("viewpage");
			break;
		case "/logout.do" :
			command = new LogOutCommand();
			command.execute(request, response);
			viewpage = (String)request.getAttribute("viewpage");
			break;
		case "/ListUpdate.do" :
			command = new ListUpdateCommand();
			command.execute(request, response);
			viewpage = (String)request.getAttribute("viewpage");
			break;
		case "/ListDelete.do" :
			command = new DeleteCommand();
			command.execute(request, response);
			viewpage = (String)request.getAttribute("viewpage");
			break;
			
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewpage);
		dispatcher.forward(request, response);
		
	}
}
	

