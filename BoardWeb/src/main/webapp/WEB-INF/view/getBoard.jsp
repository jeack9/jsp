<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp"%>
<% 
BoardVO board = (BoardVO)request.getAttribute("board");
String currPage = (String)request.getAttribute("page");
%>
<%-- <table>
<tbody>
  <tr>
    <th>글번호: </th><td></td>
  </tr>
  <tr>
    <th>내용: </th><td></td>
  </tr>
  <tr>
    <th>작성자: </th><td></td>
  </tr>
</tbody>
</table>
<div class="card">
  <div class="card-header">
    <h5 class="card-title"><%=board.getTitle() %></h5>
    <h3>글번호: <%= board.getBoardNo() %> 조회수:</h3>
  </div>
  <div class="card-body">
    <p class="card-text"><%=board.getContent() %></p>
  </div>
  <div class="card-footer text-body-secondary">
    <%=board.getCreationDate() %>
  </div>
</div>
<a href="boardList.do" class="btn btn-primary">목록</a> --%>

<h1><%= board.getBoardNo() %>. <%=board.getTitle() %></h1>
<h3>내용: <%=board.getContent() %></h3>
<h3>작성자: <%=board.getWriter() %></h3>
<h3>조회수: <%=board.getClickCnt() %></h3>
<h3>작성날짜: <%=board.getCreationDate() %></h3>
<a href="boardList.do?page=<%=currPage%>"><button type=button class="btn btn-primary">목록</button></a>
<a href="boardList.do?page=<%=currPage%>"><button type=button class="btn btn-danger">삭제</button></a>
<%@include file="../public/footer.jsp"%>