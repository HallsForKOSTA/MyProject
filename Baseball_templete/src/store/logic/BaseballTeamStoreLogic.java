package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.BaseballTeam;
import store.BaseballTeamStore;
import store.utils.ConnectionFactory;
import store.utils.JdbcUtils;

public class BaseballTeamStoreLogic implements BaseballTeamStore {
	private ConnectionFactory factory;

	public BaseballTeamStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public BaseballTeam retrieve(String teamId) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BaseballTeam base = null;
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("SELECT id,name,region,manager,stadium,logo FROM team_tb WHERE id=? ");
			pstmt.setString(1, teamId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				base = new BaseballTeam();
				base.setTeamId(Integer.toString(rs.getInt("id")));
				base.setName(rs.getString("name"));
				base.setRegion(rs.getString("region"));
				base.setManager(rs.getString("manager"));
				base.setStadium(rs.getString("stadium"));
				base.setLogo(rs.getString("logo"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return base;
	}

	@Override
	public List<BaseballTeam> retrieveAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BaseballTeam> baseList = new ArrayList<>();

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("SELECT id,name,region,manager,stadium,logo FROM team_tb order by id");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BaseballTeam base = new BaseballTeam();
				base.setTeamId(Integer.toString(rs.getInt("id")));
				base.setName(rs.getString("name"));
				base.setRegion(rs.getString("region"));
				base.setManager(rs.getString("manager"));
				base.setStadium(rs.getString("stadium"));
				base.setLogo(rs.getString("logo"));

				baseList.add(base);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return baseList;
	}

}
