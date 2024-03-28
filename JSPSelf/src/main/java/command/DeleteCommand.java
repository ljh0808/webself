package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljh.dao.DeleteDAO;

public class DeleteCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		DeleteDAO dao = new DeleteDAO();
		int num = Integer.parseInt(request.getParameter("num"));
		dao.deletelist(num);
		request.setAttribute("viewpage","/List.do");
	}

}
