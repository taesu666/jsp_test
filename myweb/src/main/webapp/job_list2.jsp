<%@page import="java.util.List"%>
<%@page import="myjsp.EmpUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<String> jobList = EmpUtil.getJobList();
%>
	<form action="emp_list.jsp">
		<select id = "jobId" name = "jobId">
			<% for (String jobId : jobList){%>
			<option value = "<%=jobId %>"><%=jobId %></option>
			
			<%}%>
		</select>
		<input type="submit" value="해당 직무 직원 목록 조회">
	</form>
	
	<script type= "text/javascript">
	
	/* 
		1. select태그를 참조한다
		2. select태그의 선택이 변경되어 함수가 실행되게 한다
	*/
	// let jobId = document.getElementById("jobId");
	let jobId = document.querySelector("#jobId");
	// jobId.onchange = handleJobId;
	jobId.addEventListener("change", handleJobId);

	function handleJobId() {
		alert(jobId.value);
		
	}

	
	</script>
	
	
</body>
</html>