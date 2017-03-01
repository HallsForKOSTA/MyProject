package hr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/login.do" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String loginId = request.getParameter("loginId");
		String passwd = request.getParameter("passwd");
		
//		패스워드가 1234이면 로그인 성공
		
		if("1234".equals(passwd)){
//			로그인에 성공하면 세션에 로그인 아이디 저장
			HttpSession session = request.getSession();
			session.setAttribute("loginId", loginId);
//			메뉴페이지로 이동
			
			response.sendRedirect(request.getContextPath() + "/views/menu.jsp");
			
		}else{
//			로그인에 실패하면 로그인 페이지로 이동
			response.sendRedirect(request.getContextPath() +"/views/login.jsp");  // /넣는 순간 hr이 빠짐  /안넣으면 hr/views/
		}
		
	}

}
