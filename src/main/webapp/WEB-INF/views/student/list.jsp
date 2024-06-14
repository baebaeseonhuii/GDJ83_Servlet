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
	<h1 class="h1">Student List</h1>
	


	<!-- JSTL -->
	<!-- for(데이터타입 변수명: 배열명) -->
	<table class="tbl">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>평균</th>
		</tr>
		<c:forEach items="${requestScope.studentList}" var="student">
			<tr>
				<th>${pageScope.student.num}</th>
				<td><a href="./detail?num=${pageScope.student.num}">${pageScope.student.name}</a></td>
				<td>${pageScope.student.avg}</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>