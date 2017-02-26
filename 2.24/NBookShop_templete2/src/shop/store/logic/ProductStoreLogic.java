package shop.store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import shop.domain.Product;
import shop.store.facade.ProductStore;
import shop.store.utils.ConnectionFactory;
import shop.store.utils.JdbcUtils;

public class ProductStoreLogic implements ProductStore {
	private ConnectionFactory factory;

	public ProductStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public List<Product> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<>();

		try {
			conn = factory.createConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT serialNo, name, price, userLike FROM product_tb");

			while (rs.next()) {
				Product product = new Product();
				product.setSerialNo(rs.getInt("serialNo"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setLike(rs.getInt("userLike"));

				list.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, stmt, rs);
		}

		return list;
	}

	@Override
	public Product findByNo(int serial) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Product product = null;

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("SELECT serialNo,name,price,userLike FROM product_tb WHERE serialNo =?");
			pstmt.setInt(1, serial);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				product = new Product();
				product.setSerialNo(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setLike(rs.getInt(4));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return product;
	}

}
