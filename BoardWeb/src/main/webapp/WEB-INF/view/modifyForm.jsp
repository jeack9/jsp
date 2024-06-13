<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../public/header.jsp"></jsp:include>
<h3>게시글 수정 화면</h3>
<h1>글번호: ${board.boardNo}.</h1>
<form action="updateBoard.do?boardNo=${requestScope.board.boardNo}&page=${requestScope.currPage}" method="post">
	<table class="table">
	  <tr>
	  	<th>제목</th>
	  	<td><input type="text" name="title" value="${board.title}"></td>
	  </tr>
	  <tr>
	  	<th>작성자</th>
	  	<td><input type="text" name="writer" value="${board.writer }"></td>
	  </tr>
	  <tr>
	  	<th>내용</th>
	  	<td><textarea rows="3" cols="60" name="content">${board.content }</textarea></td>
	  </tr>
	</table>
	<h3>조회수: ${board.clickCnt }</h3>
	<h3>작성날짜: ${board.creationDate }</h3>
	<a href="boardList.do?page=${currPage }"><button type="button" class="btn btn-primary">목록</button></a>
	<button type="submit" class="btn btn-success">진짜로 수정</button>
</form>
<jsp:include page="../public/footer.jsp"></jsp:include>