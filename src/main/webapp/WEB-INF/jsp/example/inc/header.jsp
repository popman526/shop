<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
<sec:authentication property="principal.username"/>님 안녕하세요.<br>
<form action="/logout" method="post">
	<input type="submit" value="Log Out" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</sec:authorize>
<a href="/home">홈</a>