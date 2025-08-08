package myjsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmployeeDAO {
	
	public static List<Emp> getEmpList() throws Exception {
		List<Emp> empList = new ArrayList<Emp>();
		Connection connection = getConnection();
		String sql = "select first_name, employee_id ,department_id,salary from employees";
		PreparedStatement psmt = connection.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()){
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.departmentId = rs.getString("department_id");
			emp.salary = rs.getInt("salary");

			empList.add(emp);
		}
		connection.close();
		return empList;
	}
	
	private static Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envContext.lookup("jdbc/mydb");
		Connection connection = dataSource.getConnection();
		return connection;
	}
	
	public static List<Emp> getEmpListByEmId(String empId) throws Exception {
		List<Emp> empList = new ArrayList<Emp>();
		Connection connection = getConnection();
		String sql = "select first_name, employee_id ,department_id,salary from employees where employee_id = ?";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, empId);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()){
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.departmentId = rs.getString("department_id");
			emp.salary = rs.getInt("salary");

			empList.add(emp);
		}
		connection.close();
		return empList;
	}
	
	
	public static List<Emp> getEmpListByFirst(String firstName) throws Exception {
		List<Emp> empList = new ArrayList<Emp>();
		Connection connection = getConnection();
		String sql = "select first_name, employee_id ,department_id,salary from employees where first_name = ?";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, firstName);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()){
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.departmentId = rs.getString("department_id");
			emp.salary = rs.getInt("salary");

			empList.add(emp);
		}
		connection.close();
		return empList;
	}
	
	
	public static List<Emp> getEmpListByDepId(String deptId) throws Exception {
		List<Emp> empList = new ArrayList<Emp>();
		Connection connection = getConnection();
		String sql = "select first_name, employee_id ,department_id,salary from employees where department_id = ?";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, deptId);
		ResultSet rs = psmt.executeQuery();

		while(rs.next()){
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.departmentId = rs.getString("department_id");
			emp.salary = rs.getInt("salary");

			empList.add(emp);
		}
		connection.close();
		return empList;
	}
}
