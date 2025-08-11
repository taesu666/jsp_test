<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.html"></jsp:include>

<body>
<h1>main.jsp</h1>
<%
	String action = request.getParameter("action");
	System.out.println(action);
%>
<p>this is include test</p>
<jsp:forward page="emp_list.jsp"></jsp:forward>
<%@include file="footer.jsp" %> --> @include
<jsp:include page="footer.jsp"></jsp:include> --> jsp:include

</html>