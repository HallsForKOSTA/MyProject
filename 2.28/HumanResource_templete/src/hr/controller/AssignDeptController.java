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

@WebServlet("/dept/assign.do")
public class AssignDeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HumanResourceService service;

	public AssignDeptController() {
		service = new HumanResourceServiceLogic();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empNo = request.getParameter("empNo");

		Employee emp = service.findEmployee(empNo);

		List<Department> list = service.findAllDepartment();

		request.setAttribute("emp", emp);
		request.setAttribute("deptList", list);

		request.getRequestDispatcher("/views/assignDept.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String deptNo = req.getParameter("deptNo");
		String empNo = req.getParameter("empNo");
		
		//Department dept=service.findDepartment(deptNo);
		Employee emp = service.findEmployee(empNo);
		emp.setDeptNo(deptNo);		
		service.modify(emp);
		
		resp.sendRedirect(req.getContextPath() + "/views/menu.jsp");
		

	}

}
