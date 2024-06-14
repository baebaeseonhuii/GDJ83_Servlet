<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>날씨 정보 한개 추가</h1>

<form action="./add" method="post">
	<div>
		<label>City</label>
		<input type="text" name="city"> <!-- 안에 들어가는게 파라미터 -->
	</div>
	
	<div>
		<label>Temperature</label>
		<input type="text" name="gion">
	</div>
	
	<div>
		<label>Status</label>
		<input type="text" name="status">
	</div>
	
	<div>
		<label>Humidity</label>
		<input type="text" name="humidity">
	</div>
	
	
	
	<input type="submit" value="Submit"> <!-- form을 action의 주소로 전송하는 이벤트: submit -->
	<button type="submit">Submit</button>


</form>
</body>
</html>