<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String name = (String) request.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/tables.css" rel="stylesheet">
</head>
<body>
	<h1 class="h1">학생 한명 정보</h1>

	<!-- EL(Expression Language 데이터 출력 전용-->
	<!-- getter의 이름으로 속성을 꺼냄 -->
	<!-- getter의 이름: get을 빼고 첫글자를 소문자로 바꾼 것 -->
	<!-- setter의 이름: set을 빼고 첫글자를 소문자로 바꾼 것 -->

	<table class="tbl">
		<thead>
			<tr>
				<th>Num</th>
				<th>Name</th>
				<th>Korean</th>
				<th>English</th>
				<th>Math</th>
				<th>Total Score</th>
				<th>Average Score</th>
			</tr>
			
			<tr>
				<td>${requestScope.studentDetail.num}</td>
				<td>${requestScope.studentDetail.name}</td>
				<td>${requestScope.studentDetail.kor}</td>
				<td>${requestScope.studentDetail.eng}</td>
				<td>${requestScope.studentDetail.math}</td>
				<td>${requestScope.studentDetail.total}</td>
				<td>${requestScope.studentDetail.avg}</td>
			</tr>
		</thead>
	</table>

</body>
</html>