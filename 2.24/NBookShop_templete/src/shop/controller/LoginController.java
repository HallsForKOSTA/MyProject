package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.service.facade.CustomerService;
import shop.service.logic.CustomerServiceLogic;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId"); // login.html 에서 이름으로
														// 받아온다
		String password = request.getParameter("password");

		CustomerService service = new CustomerServiceLogic(); // spring 가면
																// serviceLogic을
																// 모르고 컨테이너에서
																// new를 한다.
		// CustomerService만 알고 있음
		if (service.login(userId, password)) { // 해당아이디와 비밀번호가 맞으면 true
			HttpSession session = request.getSession();   //session 을 선언 
			session.setAttribute("userId", userId); // session은 최소화 dipatch //session에 유저 아이디를 넣는다.(항상 표시할 수 있도록)
													// redireet
			response.sendRedirect("productList.do");  // 로그인이 되면 상품 리스트 항목으로 이동
		} else {
			response.sendRedirect("login.html");  //로그인이 안될시 다시 로그인 페이지로
		}
	}

}
