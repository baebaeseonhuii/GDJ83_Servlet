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

</body>
</html>