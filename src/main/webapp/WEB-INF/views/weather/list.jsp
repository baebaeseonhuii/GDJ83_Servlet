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
	<h1 class="h1">날씨 정보 전체 출력</h1>
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
		<c:forEach items="${requestScope.weatherList}" var="w">
			<tr>
				<td>${pageScope.w.num}</td>
				<td><a href="./detail">${pageScope.w.city}</a></td>
				<td>${pageScope.w.gion}</td>
				<td>${pageScope.w.status}</td>
				<td>${pageScope.w.humidity}</td>
			</tr>
		</c:forEach>





	</table>



</body>
</html>