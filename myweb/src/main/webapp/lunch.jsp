<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- http://localhost:9000/mymy/lunch.jsp?username=jhone&email=wmiso%40nsu.ac.kr&searchword=%ED%85%8C%EB%8B%88%EC%8A%A4&hobby=%EC%9A%B4%EB%8F%99&gender=%EB%82%A8%EC%9E%90&menu=%EC%A7%AC%EB%BD%95 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Map<String, String> menuList = new HashMap<String, String>();
	menuList.put("jja","짜장면");
	menuList.put("jjam","짬뽕");
	menuList.put("tang","탕수육");
%>

<%
	request.setCharacterEncoding("utf-8");
	String userName = request.getParameter("username");
	String [] hobbyList = request.getParameterValues("hobby");
	String menu = request.getParameter("menu");
	String lunch = "";

%>
	user name :
	<%=userName%><br>
<%
	if (menuList.containsKey(menu)){
		lunch = menuList.get(menu);
		out.print(lunch);
	};
%>
	hobby :
<%
	if(hobbyList != null) {
		
		for (String hobby : hobbyList){
			System.out.println(hobby);
			out.print(hobby + "<br>"); 
%>
	<%= hobby %>
	<br>
<% 
		}
	}
%>

<%
		Enumeration paramList = request.getParameterNames();
		while(paramList.hasMoreElements()) {
			String param = (String)paramList.nextElement();
			String value = request.getParameter(param);
			out.print(param + " = " + value + "<br>");
		}
%>

</body>
</html>