package hr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.domain.Department;
import hr.domain.Employee;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/employee/list.do")
public class EmployeeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HumanResourceService service = new HumanResourceServiceLogic();
		
		List<Employee> list =service.findAllEmployee();
		
		
		List<Department> dList = service.findAllDepartment();
		
		
		request.setAttribute("empList", list);
		request.setAttribute("departmentList", dList);
		request.getRequestDispatcher("/views/employeeList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
