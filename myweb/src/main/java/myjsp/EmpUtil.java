

package myjsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmpUtil {
	public static List<String> getJobList() throws Exception {
		List<String> list = new ArrayList<String>();
		
		Connection connection = getConnection();
		String sql = "select distinct job_id from employees";
		PreparedStatement psmt = connection.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString(1));
			list.add(rs.getString(1));
		}
		String[] result = new String[list.size()];
		for(int i=0; i<list.size();i++) {
			result[i] = list.get(i);
		}
		connection.close();
		return list;
	}
	private static Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envContext.lookup("jdbc/mydb");
		Connection connection = dataSource.getConnection();
		return connection;
	}
	public static List<Emp> getEmpListByJobId(String jobId) throws Exception {
		List<Emp> empList = new ArrayList<Emp>();
		Connection connection = getConnection();
		String sql = "select first_name, last_name job_id from employees where job_id = ?";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, jobId);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()){
			Emp emp = new Emp();
			emp.firstName = rs.getString("first_name");
			empList.add(emp);
		}
		connection.close();
		return empList;
	}
}
