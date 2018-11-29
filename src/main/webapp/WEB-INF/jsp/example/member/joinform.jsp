<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/example/inc/header.jsp" %>
	<h1>회원 가입</h1>
	<form id="joinForm" action="/member/join" method="POST">
		ID : <input type="text" name="memberId"><br>	
		이름 : <input type="text" name="name"><br>
		PW : <input type="password" name="password"><br>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button type="submit">가입</button>
	</form>
</body>
</html>