<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../public/header.jsp" />
<style>
.center {
  text-align: center;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}
.pagination a:hover:not(.active) {background-color: #ddd;}
</style>

<p>${paging.toString()}</p>
<h3>게시글 목록</h3>
<table class="table">
  <thead>
    <tr>
      <th>글번호</th><th>제목</th><th>작성자</th><th>조회수</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach var="bvo" items="${requestScope.boardList}">
    <tr>
      <td>${bvo.boardNo}</td>
      <td><a href="getBoard.do?boardNo=${bvo.boardNo}&page=${paging.currPage}">${bvo.title}</a></td>
      <td>${bvo.writer}</td>
      <td>${bvo.clickCnt}</td>
    </tr>
	</c:forEach>
  </tbody>
</table>
<div class="center">
  <div class="pagination">
  <!-- 10페이지 이전 버튼 [<<] -->
  <c:if test="${requestScope.paging.prev }">
  <a href="boardList.do?page=${paging.startPage - 1 }">&laquo;</a>
  </c:if>
  <!-- 10페이징 버튼 생성 [1],[2],[3].... -->
  <c:forEach var="p" begin="${paging.startPage}" end="${paging.endPage }">
  <c:choose>
    <c:when test="${p == paging.currPage}">
  	<a href="boardList.do?page=${p}" class="active">${p}</a>  
    </c:when>
    <c:otherwise>
    <a href="boardList.do?page=${p}">${p}</a>
    </c:otherwise>
  </c:choose>
  </c:forEach>
  <!-- 10페이지 이후 버튼 [>>] -->
  <c:if test="${paging.next}">
  <a href="boardList.do?page=${paging.endPage + 1}">&raquo;</a>
  </c:if>
  
  </div>
</div>
<jsp:include page="../public/footer.jsp" />