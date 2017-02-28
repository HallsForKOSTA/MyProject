package hr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.domain.Department;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/dept/list.do")
public class DeptListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HumanResourceService service = new HumanResourceServiceLogic();
		
		List<Department> list = service.findAllDepartment();
		
		request.setAttribute("deptList", list);
		
		request.getRequestDispatcher("/views/deptList.jsp").forward(request, response);  // rediret처럼 하면 contextpath가 두번 붙는다. 
		
	}

}
