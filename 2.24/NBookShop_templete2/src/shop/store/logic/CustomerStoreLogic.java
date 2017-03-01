package shop.store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shop.domain.Customer;
import shop.store.facade.CustomerStore;
import shop.store.utils.ConnectionFactory;
import shop.store.utils.JdbcUtils;

public class CustomerStoreLogic implements CustomerStore {
	private ConnectionFactory factory;

	public CustomerStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public Customer findCustomerById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Customer customer = null;

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("SELECT userId,password,name FROM customer_tb WHERE userId = ?");
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				customer = new Customer();
				customer.setUserId(rs.getString("userId"));
				customer.setPassword(rs.getString("password"));
				customer.setName(rs.getString("name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return customer;
	}

}
