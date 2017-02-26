package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shop.domain.Customer;
import shop.domain.Order;
import shop.domain.PaymentMethod;
import shop.service.facade.CustomerService;
import shop.service.facade.ProductService;
import shop.service.logic.CustomerServiceLogic;
import shop.service.logic.ProductServiceLogic;

@WebServlet("/orderConfirm.do")
public class OrderConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String[] serials = req.getParameterValues("serials");  // 히든태그로 숨겨져있는 값을 받아옴
		String userId = (String) req.getSession().getAttribute("userId");  // session에 있는 아이디를 받아오고
		String approval = req.getParameter("approval");  // 라디오 버튼 값이 true인 값을 받아온다.
		String shipAddress = req.getParameter("shipAddress"); // 주소 값을 가져온다.

		CustomerService customerService = new CustomerServiceLogic();
		ProductService productService = new ProductServiceLogic();

		Order order = new Order();

		order.setCustomer(customerService.getCustomer(userId)); // 유저아이디를 통해 customer객체를 가져오고 order객체 안에 들어있는 customer필드에 set한다.

		for (String serial : serials) {
			order.addProduct(productService.getProduct(serial));  //주문 객체에 시리얼번호를 통해 찾은 상품을 하나씩 add한다.
		}

		order.setShipAddress(shipAddress);  // order 객체에 주소를 set한다.
		order.setPayment(PaymentMethod.findBy(approval));  //열거형값을 order객체가 가지고있는 열거형 필드에 set한다.

		req.setAttribute("order", order); 

		req.getRequestDispatcher("orderConfirm.jsp").forward(req, resp);  // requset 디스패치로 전달

	}

}
