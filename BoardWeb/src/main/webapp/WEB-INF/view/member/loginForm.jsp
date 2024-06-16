<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<h3>로그인화면</h3>
<mytag:line/>

<form action="login.do" method="post">
	<table>
	  <tr>
	    <th>아이디</th><td><input type="text" name="id"></td>
	  </tr>
	  <tr>
	    <th>비밀번호</th><td><input type="password" name="pw"></td>
	  </tr>
	  <tr>
	  	<td colspan="2"><button type="submit" class="btn btn-success">로그인</button></td>
	  </tr>
	</table>
</form>
