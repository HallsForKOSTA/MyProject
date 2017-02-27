package hr.store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hr.domain.Employee;
import hr.store.EmployeeStore;
import hr.store.utils.ConnectionFactory;
import hr.store.utils.JdbcUtils;

public class EmpolyeeStoreLogic implements EmployeeStore{
	private ConnectionFactory factory;
	
	public EmpolyeeStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public List<Employee> retrieveAll() {

		return null;
	}

	@Override
	public void create(Employee employee) {
		
	}

	@Override
	public List<Employee> retrieveByDeptNo(String deptNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Employee> list = new ArrayList<>();
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("SELECT empNo, name, deptNo FROM employee_tb WHERE deptNo = ? ORDER BY empNo ASC");
			
			pstmt.setString(1, deptNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Employee emp = new Employee();
				emp.setNo(rs.getString("empNo"));
				emp.setName(rs.getString("name"));
				emp.setDeptNo(rs.getString("deptNo"));
				
				list.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn,pstmt,rs);
		}
		
		return list;
	}

	@Override
	public void update(Employee employee) {
		
		
	}

	@Override
	public Employee retrieve(String empNo) {
		
		return null;
	}

}
