<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>회원목록(관리자용)</h3>
<!-- 회원아이디/ 이름/ 비밀번호/ 이미지 -->
<table class="table">
	<thead>
		<tr><th>회원아이디</th><th>이름</th><th>비밀번호</th><th>이미지</th></tr>
	</thead>
	<tbody>
	<c:forEach var="member" items="${requestScope.memberList }">
	<tr><td>${member.userId}</td><td>${member.userName}</td><td>${member.userPw}</td><td><img src="images/${!empty member.image ? member.image : 'test.jpg'}" alt="없음" width="100"></td></tr>
	</c:forEach>
		<tr><td>아이디1</td><td>이름1</td><td>비밀번호1</td><td>이미지1</td></tr>
	</tbody>
</table>

<!-- <ul>
<c:forEach var="member" items="${memberList }">
	<li>id ${member.userId}
	<c:choose>
		<c:when test="${empty member.image }">
			<img src="">
		</c:when>
		<c:otherwise>
			<img src="images/${member.image }" width="200">
		</c:otherwise>
	</c:choose>
	</li>
  <li> id: ${member.userId} <img width="200px" src="${!empty member.image ? 'images/'.concat(member.image) : ''}"></li>
</c:forEach>
</ul> -->