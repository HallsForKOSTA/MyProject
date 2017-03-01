package hr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.domain.Department;
import hr.domain.Employee;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/employee/create.do")
public class EmployeeCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("get진입");

		String deptNo = request.getParameter("deptNo");

		HumanResourceService service = new HumanResourceServiceLogic(); // 싱글톤으로
																		// 보통
		Department dept = service.findDepartment(deptNo);
		request.setAttribute("department", dept);

		request.getRequestDispatcher("/views/employeeCreate.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("post진입");
		String empNo = request.getParameter("empNo");
		String empName = request.getParameter("empName");
		String deptNo = request.getParameter("deptNo");

		HumanResourceService service = new HumanResourceServiceLogic();
		Employee employee = new Employee(empNo,empName,deptNo);
		System.out.println(employee.getNo());
		System.out.println(employee.getDeptNo());
		
		service.registEmployee(employee);

		 response.sendRedirect(request.getContextPath() + "/views/menu.jsp");
//		if (deptNo == "") {
//			response.sendRedirect(request.getContextPath() + "/employee/list.do");
//		} else {
//			response.sendRedirect(request.getContextPath() + "/dept/detail.do?deptNo=" + deptNo);
//
//		}

	}

}
