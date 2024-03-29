package command;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljh.dao.ListDAO;
import com.ljh.dto.ListDTO;

public class ListCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		ArrayList<ListDTO> list = new ArrayList<>();
		ListDAO dao = new ListDAO();		
		try {
			list = dao.getList();
			request.setAttribute("list", list);
			request.setAttribute("viewpage", "/boardlist.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
