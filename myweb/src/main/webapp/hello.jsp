<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
this is jsp <br/>
여기는 정태수 pc입니다. 오늘도 열심히 의미있게 화이팅합시다 <br/>
<%
	String user = request.getParameter("name");
	if(user == null){	
		user= "Guest";
	}
 %>
 Hello <%= user %>
 <!-- 생성자 함수 -> 객체생성 -->
 time : <%= new Date() %>
 <a href= "http://www.naver.com">naver</a>
 <form action="http://www.naver.com">
 	<input type="submit" value="naver">
 </form>
</body>
</html>