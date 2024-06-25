<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>회원가입</h3>
<table class="table">
  <tr>
  	<th>아이디</th>
  	<td><input type="text" name="userId"></td>
  </tr>
  <tr>
  	<th>비밀번호</th>
  	<td><input type="password" name="userPw"></td>
  </tr>
  <tr>
  	<th>이름</th>
  	<td><input type="text" name="userName"></td>
  </tr>
  <tr>
  	<th>권한</th>
  	<td><input type="text" name="responsibility"></td>
  </tr>
  <tr>
  	<th>이미지</th>
  	<td><input type="file" name="myImage"></td>
  </tr>
  <tr>
    <td colspan="2" align="center">
  	  <input type="submit" class="btn btn-primary" value="가입">
    </td>
  </tr>
</table>
