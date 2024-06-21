<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style> 
  div.reply {
  	margin: 0;
  }
  div.reply div{
  	margin: auto;
  }
  div.reply ul {
  	list-style: none;
  	margin-top: 20px;
  }
  div.reply li {
  	padding-top: 1px;
  	padding-bottom: 1px;
  }
  div.reply span {
  	display: inline-block;
  }
  /* 페이징 css */
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

<!-- 댓글관련 시작 -->
<div class="container reply">
  <div class="header">
    <input type="text" class="col-sm-6" id="reply" onkeypress="addReplyEnter(event)">
    <button class="col-sm-3 btn btn-info" id="addReply">등록</button>
  </div>
  <div class="content">
  	<ul>
  	  <li>
  	  	<span class="col-sm-1">댓글번호</span>
  	  	<span class="col-sm-4">댓글내용</span>
  	  	<span class="col-sm-2">작성자</span>
  	  	<span class="col-sm-3">작성일시</span>
  	  	<span class="col-sm-1">삭제</span>
  	  </li>
  	  <li><hr></li>
  	  <li style="display: none;">
  	  	<span class="col-sm-1">댓글번호</span>
  	  	<span class="col-sm-4">댓글내용</span>
  	  	<span class="col-sm-2">작성자</span>
  	  	<span class="col-sm-3">작성일시</span>
  	  	<span class="col-sm-1"><button class="btn btn-danger" onclick="deleteRow(event)">삭제</button></span>
  	  </li>
  	</ul>
  </div> <!-- end div.content -->
  <div class="footer"> <!-- 댓글 페이징 영역 -->
  	<div class="center">
  	  <div class="pagination">
  	  	<!-- <a href="#">1</a>
  	  	<a href="#" class="active">2</a>
  	  	<a href="#">3</a>
  	  	<a href="#">4</a> -->
  	  </div>
  	</div>
  </div>
</div> <!-- end .reply -->
<!-- 댓글관련 끝. -->

<script>
const bno = "${board.boardNo}";
const replier = "${logid}"
</script>
<script src="js/replyService.js"></script>
<script src="js/reply.js"></script>