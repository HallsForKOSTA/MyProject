package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseballTeamService;
import service.logic.BaseballTeamServiceLogic;

@WebServlet("/tradeOn.do")
public class TradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	

		// 라디오 버튼의 값을 읽어와서
		// 그값과 맞는 playerid와 트레이드 상태인 사람의 아이디를 가지고 와서(0)
		// update 문으로 교환 (0)

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BaseballTeamService service = new BaseballTeamServiceLogic();

		String playerId = request.getParameter("playerId");

		String target = request.getParameter("targetPlayer");

		service.tradePlayer(playerId, target);
		
		response.sendRedirect("list.do");
	}

}
