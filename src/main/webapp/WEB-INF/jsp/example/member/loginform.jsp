<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/example/inc/header.jsp" %>
	<h1>로그인</h1>
	<c:if test="${param.error ne null}">
		<div>Invalid id and password.</div>
	</c:if>
	<form action="/performlogin" method="post">
		ID : <input type="text" name="memberId"><br> 
		PW : <input	type="password" name="password"><br>
		<input type="submit" value="로그인">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>