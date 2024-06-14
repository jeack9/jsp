<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Sidebar-->
<div class="border-end bg-white" id="sidebar-wrapper">
    <c:choose>
      <c:when test="${!empty logid }">
      <div class="sidebar-heading border-bottom bg-light">Start Bootstrap(${logid})</div>
      </c:when>
      <c:otherwise>
      <div class="sidebar-heading border-bottom bg-light">Start Bootstrap(Guest)</div>
      </c:otherwise>
    </c:choose>
    <div class="list-group list-group-flush">
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="main.do">메인페이지</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="studentForm.do">학생정보등록화면</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do?page=1">게시판목록</a>
        <c:if test="${!empty logid }">
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardForm.do">게시글등록</a>
        </c:if>
        <c:choose>
          <c:when test="${!empty logid }">
          <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃</a>
          </c:when>
          <c:otherwise>
          <a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">로그인</a>
          </c:otherwise>
        </c:choose>
    </div>
</div>