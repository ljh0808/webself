package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command {
@Override
public void execute(HttpServletRequest request, HttpServletResponse response) {
	HttpSession hs = request.getSession(); //
	hs.invalidate();
	request.setAttribute("viewpage", "/main.jsp");
	
}
}
