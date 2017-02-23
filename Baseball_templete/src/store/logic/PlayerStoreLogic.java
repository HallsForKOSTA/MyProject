package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Player;
import store.PlayerStore;
import store.utils.ConnectionFactory;
import store.utils.JdbcUtils;

public class PlayerStoreLogic implements PlayerStore {
	private ConnectionFactory factory;

	public PlayerStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public void update(Player player) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("UPDATE player_tb SET teamId=?  WHERE id=?");
			pstmt.setString(1, player.getTeamId());  // 바꾼 팀아이디
			pstmt.setString(2, player.getPlayerId());  // 기존아이디
			
					
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt);
		}

	}

	@Override
	public Player retrieve(String playerId) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Player player = null;

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"SELECT id,teamId,name,backNumber,position,hitting,throw FROM player_tb where id=? ");
			pstmt.setString(1, playerId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				player = new Player();
				player.setPlayerId(Integer.toString(rs.getInt("id")));
				player.setTeamId(Integer.toString(rs.getInt("teamId")));
				player.setName(rs.getString("name"));
				player.setBackNumber(rs.getInt("backNumber"));
				player.setPosition(rs.getString("position"));
				player.setHittingHand(rs.getString("hitting"));
				player.setThrowHand(rs.getString("throw"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return player;
	}

	@Override
	public List<Player> retrieveByTeam(String teamId) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Player> playList = new ArrayList<>();

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"SELECT id,teamId,name,backNumber,position,hitting,throw FROM player_tb where teamId=? order by teamId");
			pstmt.setString(1, teamId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Player player = new Player();
				player.setPlayerId(Integer.toString(rs.getInt("id")));
				player.setTeamId(Integer.toString(rs.getInt("teamId")));
				player.setName(rs.getString("name"));
				player.setBackNumber(rs.getInt("backNumber"));
				player.setPosition(rs.getString("position"));
				player.setHittingHand(rs.getString("hitting"));
				player.setThrowHand(rs.getString("throw"));

				playList.add(player);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return playList;
	}

}
