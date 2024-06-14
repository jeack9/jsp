<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>게시글 삭제 화면</h3>
<h1>${requestScope.board.boardNo }. ${board.title }</h1>
<h3>내용: ${board.content }</h3>
<h3>작성자: ${board.writer }</h3>
<h3>조회수: ${board.clickCnt }</h3>
<h3>작성날짜: ${board.creationDate }</h3>
<a href="boardList.do?page=${requestScope.currPage }"><button type=button class="btn btn-primary">목록</button></a>
<a href="removeBoard.do?boardNo=${board.boardNo }&page=${currPage }"><button type="button" class="btn btn-danger">진짜로 삭제</button></a>
