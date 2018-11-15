<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css" href="css/member/memberlist.css"> -->
<script type="text/javascript" src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script type="text/javascript" src="js/member/join.js"></script>
</head>
<body>
	<a href="hello">홈</a>
	<h1>회원 가입</h1>
	<form id="joinForm" action="member/join" method="POST">
		ID : <input type="text" name="memberId"><br>	
		이름 : <input type="text" name="name"><br>
		<button type="submit">가입</button>
	</form>
</body>
</html>