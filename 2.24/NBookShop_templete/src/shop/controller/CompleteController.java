package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.domain.Order;
import shop.service.facade.OrderService;
import shop.service.logic.OrderServiceLogic;

@WebServlet("/orderComplete.do")
public class CompleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Order order = (Order)request.getSession().getAttribute("order");  // session에서 order 객체를 가져오고 
		
		OrderService service = new OrderServiceLogic();
		
		if(service.order(order)){ // true가 되면 완료 페이지로 이동
			response.sendRedirect("complete.html");
		}
		
	}

}
