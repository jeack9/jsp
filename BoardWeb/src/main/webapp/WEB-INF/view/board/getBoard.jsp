<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h1>상세화면</h1>
<h1>${requestScope.board.boardNo}. ${requestScope.board.title}</h1>
<h3>내용: <c:out value="${requestScope.board.content}"/></h3>
<h3>작성자: <c:out value="${requestScope.board.writer}"/></h3>
<h3>조회수: <c:out value="${requestScope.board.clickCnt}"/></h3>
<h3>작성날짜: <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.creationDate }"/></h3>
<a href="boardList.do?page=${page}&searchCondition=${searchCondition}&keyword=${keyword}"><button type=button class="btn btn-primary">목록</button></a>
<c:choose>
	<c:when test="${!empty sessionScope.logid && sessionScope.logid == board.writer}">
	<a href="removeForm.do?boardNo=${board.boardNo}&page=${page}&searchCondition=${searchCondition}&keyword=${keyword}"><button type=button class="btn btn-danger">삭제 화면</button></a>
	<a href="modifyForm.do?boardNo=${board.boardNo}&page=${page}&searchCondition=${searchCondition}&keyword=${keyword}"><button type="button" class="btn btn-info">수정 화면</button></a>
	</c:when>
	<c:otherwise>
	<a><button type=button class="btn btn-secondary">삭제 화면</button></a>
	<a><button type="button" class="btn btn-secondary">수정 화면</button></a>
	</c:otherwise>
</c:choose>
