package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BaseballTeam;
import service.BaseballTeamService;
import service.logic.BaseballTeamServiceLogic;

@WebServlet("/teamDetail.do")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaseballTeamService service;
	
	public DetailController(){
		service = new BaseballTeamServiceLogic();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teamId= request.getParameter("baseId");
		
		BaseballTeam base=service.findTeam(teamId);
		
		request.setAttribute("base", base);
		
		request.getRequestDispatcher("teamDetail.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
