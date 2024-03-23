package command;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljh.dao.ListAddDAO;
import com.ljh.dao.ListDAO;
import com.ljh.dto.ListAddDTO;
import com.ljh.dto.ListDTO;

public class ListAddCommand implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		ListAddDTO dto = new ListAddDTO(title,content);
		ListAddDAO.Addlist(dto);
		System.out.println(dto.getContent());
		System.out.println(dto.getTitle());
		ArrayList<ListDTO> list = ListDAO.getList();
		request.setAttribute("list", list);
		request.setAttribute("viewpage", "/boardlist.jsp");
	}

}
