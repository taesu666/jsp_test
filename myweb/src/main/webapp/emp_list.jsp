<%@page import="myjsp.Emp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.util.ArrayList"%>
<%@page import="myjsp.EmpUtil"%>
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
<!-- 
	클라리언트로부터 전송딘 데이터를 추출한다
	
 -->
 <%
String jobId = request.getParameter("jobId");
List<Emp> empList = EmpUtil.getEmpListByJobId(jobId);

for(Emp emp : empList) {
%>
		<%=emp %><br/>
<%	}%> 

</body>
</html>