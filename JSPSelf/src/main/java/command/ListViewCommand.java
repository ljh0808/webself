package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljh.dao.ListViewDAO;
import com.ljh.dto.ListDTO;

public class ListViewCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("no"));
		System.out.println(num);
		ArrayList<ListDTO> list = ListViewDAO.ListView(num);
		request.setAttribute("list", list);
		request.setAttribute("viewpage", "/listView.jsp");
		
		System.out.println("값전달 성공");		
	}

}
