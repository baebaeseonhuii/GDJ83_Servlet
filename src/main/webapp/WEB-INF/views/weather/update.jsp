<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>날씨 정보 수정</h1>
<form action="./update" method="post">
<input id="num" type="hidden" name="num" value="${requestScope.weatherDTO.num}" readonly>
<div>
		<label>City</label>
		<input type="text" name="city" value="${weatherDTO.city}"> <!-- requestScope는 생략 가능 -->
	</div>
	
	<div>
		<label>Temperature</label>
		<input type="text" name="gion" value="${requestScope.weatherDTO.gion}">
	</div>
	
	<div>
		<label>Status</label>
		<input type="text" name="status" value="${requestScope.weatherDTO.status}">
	</div>
	
	<div>
		<label>Humidity</label>
		<input type="text" name="humidity" value="${requestScope.weatherDTO.humidity}">
	</div>
	
	
	
	<input type="submit" value="Submit"> 
	<button type="submit">Submit</button>


</form>
</body>
</html>