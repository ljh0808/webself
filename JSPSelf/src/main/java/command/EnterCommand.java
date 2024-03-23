package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljh.dao.MainDAO;
import com.ljh.dto.MainDTO;

public class EnterCommand implements Command{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response) {
	String id = request.getParameter("id");  
	String pwd = request.getParameter("pwd"); //입력받은값 저장
	HttpSession hs = request.getSession();   //세션생성
	MainDTO dto =  new MainDTO(id,pwd); // dto생성자이용 ,데이터삽입
	
	try {
		MainDAO.mainEnter(dto);    //DAO메서드 이용 db접속및 입력받은값 저장
		if(MainDAO.MainCheck(dto)) {
			System.out.println("아이디 비밀번호 일치");
			hs.setAttribute("id", id);
			request.setAttribute("viewpage", "/loginOk.jsp");
		}
		else {
			System.out.println("아이디 비밀번호 불일치");
			String msg = "아이디 또는 비밀번호가 일치하지 않습니다.";
			hs.setAttribute("msg", msg);
			request.setAttribute("viewpage", "/sublogin.jsp");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	


}
}
