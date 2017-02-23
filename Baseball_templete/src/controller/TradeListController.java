package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BaseballTeam;
import domain.Player;
import service.BaseballTeamService;
import service.logic.BaseballTeamServiceLogic;

@WebServlet("/tradeList.do")
public class TradeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BaseballTeamService service = new BaseballTeamServiceLogic();
		String playerId = request.getParameter("playerId");
		
		Player player = service.findPlayer(playerId);
		
		List<BaseballTeam> baseList=service.findTradeTargetPalyers(player.getTeamId());
		
		request.setAttribute("player", player);
		request.setAttribute("bases", baseList);
		
		
		request.getRequestDispatcher("tradeTargetList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
