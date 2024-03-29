package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljh.dao.JoinDAO;
import com.ljh.dto.JoinDTO;

public class JoinCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id =request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		boolean a = false;
		
		JoinDTO dto = new JoinDTO(id,pwd,name,email); //회원가입 입력값 DTO에저장
		
		try {
			JoinDAO dao = new JoinDAO();
			a =dao.joinMember(dto); //JoinDAO메서드 이용 T,F값 변수a에 저장
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(a) {

			System.out.println("회원가입 성공");
			HttpSession hs = request.getSession();
			hs.setAttribute("name", name);
			request.setAttribute("viewpage","/Hello.jsp");
		} else {
			System.out.println("회원가입 실패"); //회원가입실패 (추가사항 필요)
		}		
	}
}
