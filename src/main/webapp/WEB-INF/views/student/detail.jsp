<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String name = (String)request.getAttribute("name");

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>학생 한명 정보</h1>

<!-- EL(Expression Language 데이터 출력 전용-->
<!-- getter의 이름으로 속성을 꺼냄 -->
<!-- getter의 이름: get을 빼고 첫글자를 소문자로 바꾼 것 -->
<!-- setter의 이름: set을 빼고 첫글자를 소문자로 바꾼 것 -->
<h3>${requestScope.student.name}</h3>
<h3>${requestScope.student.num}</h3>
<h3>${requestScope.student.avg}</h3>
</body>
</html>