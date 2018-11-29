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
	<h1>Hello World</h1>
	<h2>This is JSP</h2>
	<sec:authorize access="hasRole('ADMIN')">
		<a href="memberslist">회원 리스트</a>
	</sec:authorize>
</body>
</html>