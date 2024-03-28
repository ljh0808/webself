package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljh.dao.ListViewDAO;
import com.ljh.dto.ListDTO;

public class ListViewCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("no"));
		ArrayList<ListDTO> list = new ArrayList<>();
		ListViewDAO dao = new ListViewDAO();
		list = dao.ListView(num);
		request.setAttribute("list", list);
		
		HttpSession session = request.getSession(false);
		String userId = (String)session.getAttribute("id");
		String writer = null;
		System.out.println(userId + "유저세션값" );
		for(ListDTO a: list) {
				writer = a.writer;
		}
		System.out.println(writer+"writer 값");
		

		if(writer != null && userId != null) {
			if(userId.equals(writer)) {
				request.setAttribute("viewpage","/mylistView.jsp");
				System.out.println("본인 게시글 조회");
			}
		}else {
		request.setAttribute("viewpage","/listView.jsp");
		System.out.println("타인 게시글 조회");	
		}
}
}
