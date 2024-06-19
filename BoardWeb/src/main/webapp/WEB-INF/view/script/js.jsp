<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>자바스크립트 연습</h3>
<ul id="fruit">
	<li>apple</li>
	<li>banana</li>
</ul>

<div id="dom">
<table class="table">
	<tr>
		<th>회원아이디</th>
		<td><input type="text" id="mid"></td>
	</tr>
	<tr>
		<th>회원이름</th>
		<td><input type="text" id="mname"></td>
	</tr>
	<tr>
		<th>회원연락처</th>
		<td><input type="text" id="mphone"></td>
	</tr>
	<tr>
		<th>회원점수</th>
		<td><input type="text" id="mpoint"></td>
	</tr>
	<tr>
		<td colspan="2">
			<button id="addBtn" class="btn btn-success" type="button">추가</button>
			<button id="modBtn" class="btn btn-info" type="button">수정</button>
			<button id="delBtn" class="btn btn-danger" type="button">선택삭제</button>
		</td>
	</tr>
</table>
<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>연락처</th>
			<th>포인트</th>
			<th>삭제</th>
			<th><input type="checkbox"></th>
		</tr>
	</thead>
	<tbody id="member_list">

	</tbody>
</table>
<select name="" id="selectMonth">
	<option value="5">5월</option>
	<option value="6">6월</option>
	<option value="7">7월</option>
</select>
</div> <!-- end of div#dom -->
<div id="show"></div>


<table class="table">
	<tr>
		<th>사번</th>
		<td><input type="text" id="empNo"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" id="empName"></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><input type="text" id="empEmail"></td>
	</tr>
	<tr>
		<th>급여</th>
		<td><input type="text" id="empSalary"></td>
	</tr>
	<tr>
		<td colspan="2">
			<button id="empAddBtn" class="btn btn-success" type="button">추가</button>
			<!-- <button id="modBtn" class="btn btn-info" type="button">수정</button>
			<button id="delBtn" class="btn btn-danger" type="button">선택삭제</button> -->
		</td>
	</tr>
</table>
<table class="table">
	<thead>
		<tr>
			<th>사번</th>
			<th>firsName</th>
			<th>이메일</th>
			<th>급여</th>
		</tr>
	</thead>
	<tbody id="list"></tbody>
</table>

<script src="js/data.js"></script>
<script src="js/basic.js"></script>
<script src="js/func1.js"></script>
<script src="js/calendar.js"></script>
<script src="js/ary2.js"></script>
<script src="js/dom1.js"></script>