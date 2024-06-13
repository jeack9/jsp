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
	<table border="2">
	<tbody>
		<tr>
			<th>학생번호</th>
			<td>${requestScope.student.stdNo }</td>
		</tr>
		<tr>
			<th>학생이름</th>
			<td>${student.stdName }</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${student.phone }</td>
		</tr>
		<tr>
			<th>혈액형</th>
			<td>${student.bldType }</td>
		</tr>	
	</tbody>
	</table>
</body>
</html>