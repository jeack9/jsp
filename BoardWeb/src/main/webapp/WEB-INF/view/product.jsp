<%@page import="co.yedam.vo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Product페이지</h3>
	<%
			Student student = (Student)request.getAttribute("student");
	%>
	<table border="2">
	<tbody>
		<tr>
			<th>학생번호</th>
			<td><%= student.getStdNo() %></td>
		</tr>
		<tr>
			<th>학생이름</th>
			<td><%= student.getStdName() %></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%= student.getPhone() %></td>
		</tr>
		<tr>
			<th>혈액형</th>
			<td><%= student.getBldType() %></td>
		</tr>	
	</tbody>
	</table>
</body>
</html>