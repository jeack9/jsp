<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../public/header.jsp"/>
<h3>게시글등록화면</h3>
<form action="addBoard.do" method="get">
	<table class="table">
	  <tr>
	  	<th>제목</th>
	  	<td><input type="text" name="title"></td>
	  </tr>
	  <tr>
	  	<th>작성자</th>
	  	<td><input type="text" name="writer" value="${sessionScope.logid}" readonly></td>
	  </tr>
	  <tr>
	  	<th>내용</th>
	  	<td><textarea rows="3" cols="60" name="content"></textarea></td>
	  </tr>
	  <tr>
	    <td colspan="2" align="center">
	  	  <input type="submit" class="btn btn-primary" value="저장">
	    </td>
	  </tr>
	</table>
</form>
<jsp:include page="../public/footer.jsp"/>