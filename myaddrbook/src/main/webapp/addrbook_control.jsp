<%@page import="addrbook.AddrBookVO"%>
<%@page import="java.util.List"%>
<%@page import="addrbook.AddrBookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="ab" class="addrbook.AddrBookVO"></jsp:useBean>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:setProperty property="*" name="ab"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//	request.setCharacterEncoding("utf-8");
/* client의 요구(action 참조)에 따라 처리 */
/* insert, update, delete, list */
	String action = request.getParameter("action");
	System.out.println("action = " +action);
	String forwardPage = "addrbook_list.jsp";
	AddrBookDAO dao = new AddrBookDAO();
	if("insert".equals(action)){
		//insert - DAO.insert();
		
		dao.insertDB(ab);
		//목록이 출력되게
		//forwardPage를 설정한다
		response.sendRedirect("addrbook_control.jsp?action=list");
		System.out.println("ab: " + ab);
	} else if("edit".equals(action)){
		//1. 클라이언트가 전송한 데이터 중에서 방명록 id를 추출한다.
		String abIdStr = request.getParameter("ab_id");
		//2. DB에서 해당 방명록 정보를 조회한다
		AddrBookVO vo = dao.getDB(Integer.parseInt(abIdStr));
		//3. 방명록 정보를 리퀘스트에 넣는다
		forwardPage = "addrbook_edit_form.jsp";	
		request.setAttribute("ab", vo);
		pageContext.forward(forwardPage);
	}else if("delete".equals(action)){
		//scope request에 data라는 이름으로 리스트를 넣어두어야한다
		//jsp에 꺼내서 출력한다
		String abIdStr = request.getParameter("ab_id");
		AddrBookVO vo = dao.deleteDB(Integer.parseInt(abIdStr));
		response.sendRedirect("addrbook_control.jsp?action=list");


	}else if("list".equals(action)){
		//scope request에 data라는 이름으로 리스트를 넣어두어야한다
		//jsp에 꺼내서 출력한다
		List<AddrBookVO> list = dao.getDBList();
		request.setAttribute("data", list);
		System.out.println(list);
		pageContext.forward(forwardPage);
	}else {
		response.sendRedirect("addrbook_control.jsp?action=list");

	}
	
	
%>
<%-- <jsp:forward page="<%=forwardPage %>"></jsp:forward>
 --%></body>
</html>