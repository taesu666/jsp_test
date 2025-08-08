<%@page import="myjsp.EmployeeTO"%>
<%@page import="myjsp.EmployeeDAO"%>
<%@page import="myjsp.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>Employee 검색</h2>
	</div>
	<div>
		<form action="listEmp.jsp">
			<select name="searchType">
				<option value="employee_id">employee_id</option>
				<option value="first_name">first_name</option>
				<option value="department_id">department_id</option>
			</select> <input type="text" name="searchText"> <input type="submit"
				value="search">

		</form>
	</div>
	<%
	
	String name = request.getParameter("searchType");
	String column = request.getParameter("searchText");
	List<Emp> empList = EmployeeDAO.getEmpList();
	
	if("first_name".equals(name)){
		empList = EmployeeDAO.getEmpListByFirst(column);
		
	} else if("employee_id".equals(name)){
		empList = EmployeeDAO.getEmpListByEmId(column);
	}else if("department_id".equals(name)){
		empList = EmployeeDAO.getEmpListByDepId(column);
	}
	
	for(Emp emp : empList) {
	%>
	
		<table border="1">
			<tr>
				<td><%=emp.employeeId%></td>
				<td><%=emp.firstName%></td>
				<td><%=emp.salary%></td>
				<td><%=emp.departmentId%></td>
				
				
			</tr>
		</table>
<%	}%> 

</body>
</html>