<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>회원목록(관리자용)</h3>

<ul>
<c:forEach var="member" items="${memberList }">
    <li> id: ${member.userId} ${!empty member.image ? '<img src=imges/member.image>' : ""}</li>
</c:forEach>

</ul>