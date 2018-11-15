<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/member/memberlist.css">
<script type="text/javascript" src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script type="text/javascript" src="js/member/memberlist.js"></script>
</head>
<body>
	<a href="home">home</a>
	<a href="hello">hello</a>
	<h1>회원 목록</h1>
	<table class="simple-table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Member ID</th>
				<th>Name</th>
				<th>Member Type</th>
			</tr>
		</thead>
		<tbody id="members">
		</tbody>		
	</table>
	
</body>
</html>