<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<h3>main 페이지</h3>
	<p>학생번호: ${requestScope.student.stdNo}</p>
	<p>학생이름: ${student.stdName }</p>
	<p>전화번호: ${student.phone }</p>
	<p>혈액형: ${student.bldType }</p>
	
	<h3>학생목록</h3>
	<ul>
		<c:forEach var="std" items="${requestScope.studentList }">		
		<li>학번: ${std.stdNo } 
			이름: <a href="product.do?stdNo=${std.stdNo }" >${std.stdName }</a> 
			연락처: ${std.phone }</li>
		</c:forEach>
	</ul>
