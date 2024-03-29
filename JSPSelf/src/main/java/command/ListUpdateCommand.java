package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljh.dao.ListDAO;
import com.ljh.dto.ListDTO;

public class ListUpdateCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("no");
		String title =request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(num);
		ListDTO dto = new ListDTO(num,title,content);
		ListDAO dao = new ListDAO();
		try {
			dao.updateList(dto);
			request.setAttribute("viewpage", "/ListView.do");		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
