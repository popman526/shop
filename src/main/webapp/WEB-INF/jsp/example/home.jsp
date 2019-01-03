<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/example/inc/header.jsp" %>
	<h1>Wellcome!!</h1>
	<h2>HOME</h2>
	<a href="/hello">hello</a>
	
	<sec:authorize access="!isAuthenticated()">
		<a href="/loginform">login</a>
		<a href="/joinform">join</a>
	</sec:authorize>
</body>
</html>