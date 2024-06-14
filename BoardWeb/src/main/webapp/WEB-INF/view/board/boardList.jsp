<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<div class="center">
  <form action="boardList.do">
    <div class="row">
      <div class="col-sm-4">
        <select name="searchCondition" class="form-control">
          <option value="">선택하세요</option>
          <option value="T">제목</option>
          <option value="W">작성자</option>
          <option value="TW">제목&작성자</option>
        </select>
      </div>
      <div class="col-sm-6">
        <input type="text" name="keyword" class="form-control">
      </div>
      <div class="col-sm-2">
        <input type="submit" value="찾기" class="btn btn-primary">
      </div>
    </div>
  </form>
</div>

<p>sc: ${searchCondition}, kw: ${keyword}</p>
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
      <td><a href="getBoard.do?boardNo=${bvo.boardNo}&page=${paging.currPage}&searchCondition=${searchCondition}&keyword=${keyword}">${bvo.title}</a></td>
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
  <a href="boardList.do?page=${paging.startPage - 1 }&searchCondition=${searchCondition}&keyword=${keyword}">&laquo;</a>
  </c:if>
  <!-- 10페이징 버튼 생성 [1],[2],[3].... -->
  <c:forEach var="p" begin="${paging.startPage}" end="${paging.endPage }">
  <a href="boardList.do?page=${p}&searchCondition=${searchCondition}&keyword=${keyword}" class="${p == paging.currPage ? 'active' : '' }">${p}</a>  
  </c:forEach>
  <!-- 10페이지 이후 버튼 [>>] -->
  <c:if test="${paging.next}">
  <a href="boardList.do?page=${paging.endPage + 1}&searchCondition=${searchCondition}&keyword=${keyword}">&raquo;</a>
  </c:if>
  
  </div>
</div>
