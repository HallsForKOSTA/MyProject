package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.domain.Customer;
import shop.domain.Product;
import shop.service.facade.CustomerService;
import shop.service.facade.ProductService;
import shop.service.logic.CustomerServiceLogic;
import shop.service.logic.ProductServiceLogic;

@WebServlet("/order.do")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CustomerService customerService = new CustomerServiceLogic();
		ProductService productService = new ProductServiceLogic();
		
		String [] serials = request.getParameterValues("buyItems"); // checkbox들의 체크된 값들을 파라미터values로 이름으로 가져와서  배열로 받는다.
		
		HttpSession session = request.getSession(); // session 선언
		String userId = (String)session.getAttribute("userId");  //세션에 있는 유저의아이디를 String 다운캐스팅해서 String으로 받는다.
		
		Customer customer = customerService.getCustomer(userId); // 유저아이디를 통하여 해당 customer를 찾는다.
		
		List<Product> list = productService.getBuyProducts(serials); //가져온 시리얼번호 배열을 통해 상품리스트 배열을 찾아온다. 
		
		request.setAttribute("customer", customer); // 다음페이지로 객체 전달을 위해 setAttribute를 하고
		request.setAttribute("products", list);
		
		request.getRequestDispatcher("orderForm.jsp").forward(request, response); // 디스패처로 orderForm에 요청한다.
	}

}
