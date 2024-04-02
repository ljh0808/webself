package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljh.dao.DeleteDAO;

public class DeleteCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		DeleteDAO dao = new DeleteDAO();
		int num = Integer.parseInt(request.getParameter("num"));
		try {
			dao.deletelist(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("redirect","/list.do");
		System.out.println("delete 종료");
	}

}
