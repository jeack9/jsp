<%@page import="co.yedam.vo.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
	<h3>main 페이지</h3>
	<%
		Student std = (Student)request.getAttribute("student");
		List<Student> list = (List<Student>)request.getAttribute("studentList");
	%>
	<p>학생번호: <%=std.getStdNo()%></p>
	<p>학생이름: <%=std.getStdName()%></p>
	<p>전화번호: <%=std.getPhone()%></p>
	<p>혈액형: <%=std.getBldType()%></p>
	
	<h3>학생목록</h3>
	<ul>
		<%
		 for(Student student : list){
		%>
		<li>학번: <%= student.getStdNo() %> 
			이름: <a href="product.do?stdNo=<%= student.getStdNo() %>" ><%= student.getStdName() %></a> 
			연락처: <%= student.getPhone() %></li>
		<% } %>
	</ul>
<%@include file="footer.jsp" %>