<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../public/header.jsp"/>
<h3>학생정보등록화면</h3>
<form action="addStudent.do" method="get">
	<table class="table">
	  <tr>
	  	<th>학생번호</th>
	  	<td><input type="text" name="sno"></td>
	  </tr>
	  <tr>
	  	<th>학생이름</th>
	  	<td><input type="text" name="sname"></td>
	  </tr>
	  <tr>
	  	<th>연락처</th>
	  	<td><input type="text" name="phone"></td>
	  </tr>
	  <tr>
	  	<th>혈액형</th>
	  	<td><input type="text" name="btype"></td>
	  </tr>
	  <tr>
	    <td colspan="2" align="center">
	  	  <input type="submit" class="btn btn-primary" value="저장">
	    </td>
	  </tr>
	</table>
</form>
<jsp:include page="../public/footer.jsp"/>