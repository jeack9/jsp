<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
    #centerList b{
        color: yellowgreen;
    }
</style>
<!-- publicData -->
<h3>공공데이터 연습</h3>
<!-- 검색조건 입력하고 목록에서 출력. -->
<input type="text" id="search" placeholder="ex)동구" onkeypress="searchKwEnter(event)">
<button id="findBtn" class="btn btn-info">검색</button>
<!-- 
정보에서 중복된 시 제거 후 옵션으로 등록 change 이벤트 
=> 시 키워드로 검색 
-->
<p>도시 리스트</p>
<select id="searchList">
    <option value="">시도선택</option>
</select>
<button id="centerDB">센터DB생성</button>
<table class="table">
    <thead>
        <tr>
            <th>센터id</th>
            <th>센터명</th>
            <th>연락처</th>
            <th>주소</th>
        </tr>
        <tr style="display: none;">
            <td>아이디입니다</td>
            <td>센터명입니다</td>
            <td>연락처입니다</td>
            <td>주소입니다</td>
        </tr>
    </thead>
    <tbody id="centerList">
        
    </tbody>
</table>

<script src="js/public.js"></script>