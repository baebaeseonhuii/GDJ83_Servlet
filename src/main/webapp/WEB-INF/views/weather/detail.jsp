<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/tables.css" rel="stylesheet">

</head>
<body>
	<h1 class="h1">날씨 정보 한개 보기</h1>
	<table class="tbl">
		<thead>
			<tr>
				<th>Num</th>
				<th>City</th>
				<th>Temperature</th>
				<th>Status</th>
				<th>humidity</th>
			</tr>
		</thead>

		<tr>
			<td>${requestScope.weatherDetail.num}</td>
			<td>${requestScope.weatherDetail.city}</td>
			<td>${requestScope.weatherDetail.gion}</td>
			<td>${requestScope.weatherDetail.status}</td>
			<td>${requestScope.weatherDetail.humidity}</td>
		</tr>

	</table>
	
	
	<form id="frm" action="./delete" method="post">
		<input id="num" type="hidden" name="num" value="${requestScope.weatherDetail.num}" readonly>
		<!-- 사용자에게 안보이고싶은 정보는 hidden으로 막아 놓기 -->
	</form>
	
	
	<button type="button" id="btn">DELETE</button>
	<button type="button" id="up">UPDATE</button>
	
	<script type="text/javascript">
	const btn = document.getElementById("btn");
	const up = document.getElementById("up");
	const frm = document.getElementById("frm");
	
	btn.addEventListener("click", function() {
		frm.submit(); //버튼을 클릭하면 submit 이벤트를 강제로 실행
	})
	
	up.addEventListener("click", function() {
		//method 형식을 GET으로 바꾸고 싶다
		frm.setAttribute("method", "get");
		frm.method = "get";
		frm.setAttribute("action", "./update");
		frm.submit(); //버튼을 클릭하면 submit 이벤트를 강제로 실행
	})
	
	</script>
	
	
</body>
</html>