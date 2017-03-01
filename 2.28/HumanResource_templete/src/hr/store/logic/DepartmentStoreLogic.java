package hr.store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hr.domain.Department;
import hr.store.DepartmentStore;
import hr.store.utils.ConnectionFactory;
import hr.store.utils.JdbcUtils;

public class DepartmentStoreLogic implements DepartmentStore {
	private ConnectionFactory factory;

	public DepartmentStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public List<Department> retrieveAll() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Department> list = new ArrayList<>();

		try {
			conn = factory.createConnection();
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SELECT deptNO,deptName ");
			sqlBuilder.append("FROM dept_tb ");
			sqlBuilder.append("ORDER BY deptNO ASC");

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlBuilder.toString());

			while (rs.next()) {
				Department dept = new Department(rs.getString("deptNo"), rs.getString("deptName"));

				list.add(dept);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JdbcUtils.close(conn, stmt, rs);
		}

		return list;
	}

	@Override
	public void create(Department department) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("INSERT INTO dept_tb (deptNo,deptName) VALUES(?,?)");
			pstmt.setString(1, department.getNo());
			pstmt.setString(2, department.getName());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt);
		}

	}

	@Override
	public Department retrieve(String deptNo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Department dept = null;

		try {
			conn = factory.createConnection();

			pstmt = conn.prepareStatement("SELECT deptNo, deptName FROM dept_tb WHERE deptNo = ?");
			pstmt.setString(1, deptNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dept = new Department(rs.getString("deptNo"), rs.getString("deptName"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt, rs);
		}

		return dept;
	}

	@Override
	public void delete(String deptNo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("DELETE FROM dept_tb WHERE deptNo=?");
			pstmt.setString(1, deptNo);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt);
		}

	}

}
