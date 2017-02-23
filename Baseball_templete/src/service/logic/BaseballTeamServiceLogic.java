package service.logic;

import java.util.ArrayList;
import java.util.List;

import domain.BaseballTeam;
import domain.Player;
import service.BaseballTeamService;
import store.BaseballTeamStore;
import store.PlayerStore;
import store.logic.BaseballTeamStoreLogic;
import store.logic.PlayerStoreLogic;

public class BaseballTeamServiceLogic implements BaseballTeamService {
	private BaseballTeamStore store;
	private PlayerStore storeP;


	public BaseballTeamServiceLogic() {
		store = new BaseballTeamStoreLogic();
		storeP = new PlayerStoreLogic();
	}

	@Override
	public BaseballTeam findTeam(String teamId) {

		return store.retrieve(teamId);
	}

	@Override
	public List<BaseballTeam> findAllTeams() {

		return store.retrieveAll();
	}

	@Override
	public List<BaseballTeam> findAllTeamsWithPlayers() {

		List<BaseballTeam> baseList = new ArrayList<>();

		baseList = store.retrieveAll();
		for (BaseballTeam b : baseList) {
			b.setPlayers(storeP.retrieveByTeam(b.getTeamId()));

		}

		return baseList;
	}

	@Override
	public List<BaseballTeam> findTradeTargetPalyers(String teamId) {

		List<BaseballTeam> baseList = new ArrayList<>();
		// BaseballTeam base = store.retrieve(teamId);

		baseList = store.retrieveAll();
		for (BaseballTeam b : baseList) {
			if (b.getTeamId().equals(teamId))
				continue;
			b.setPlayers(storeP.retrieveByTeam(b.getTeamId()));

		}

		return baseList;
	}

	@Override
	public Player findPlayer(String playerId) {

		return storeP.retrieve(playerId);
	}

	@Override
	public void tradePlayer(String sourcePlayerId, String targetPlayerId) {
		BaseballTeamService service=new BaseballTeamServiceLogic();

		Player my = service.findPlayer(sourcePlayerId);
		Player target = service.findPlayer(targetPlayerId);

		String myTeamId = my.getTeamId();

		my.setTeamId(target.getTeamId());
		target.setTeamId(myTeamId);

		storeP.update(my);
		storeP.update(target);

	}

}
