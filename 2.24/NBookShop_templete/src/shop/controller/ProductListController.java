package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.domain.Product;
import shop.service.facade.ProductService;
import shop.service.logic.ProductServiceLogic;

@WebServlet("/productList.do")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductService service = new ProductServiceLogic();

		List<Product> list = service.getAllProducts();  // 모든 상품을 찾아온다.

		request.setAttribute("products", list);  // 상품리스트를 속성에 넣어서 request에 넣는다.

		request.getRequestDispatcher("productList.jsp").forward(request, response); // productList.jsp 파일로 request에 속성을 담아서 넘겨준다.
		

	}

}
