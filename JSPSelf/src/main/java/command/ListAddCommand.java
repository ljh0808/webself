package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljh.dao.ListAddDAO;
import com.ljh.dao.ListDAO;
import com.ljh.dto.ListDTO;

public class ListAddCommand implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		HttpSession session = request.getSession(false);
		String writer = (String)session.getAttribute("id");
		ListDTO dto;
		
		dto = new ListDTO(title,content,writer);
		
		ListAddDAO dao = new ListAddDAO();
		dao.Addlist(dto);
		
		System.out.println(dto.getContent());
		System.out.println(dto.getTitle());
		ArrayList<ListDTO> list = new ArrayList<>(); 
		ListDAO Ldao = new ListDAO();		
		list = Ldao.getList();
		request.setAttribute("list", list);
		request.setAttribute("viewpage", "/boardlist.jsp");
	}

}
