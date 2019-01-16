<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019-01-16
  Time: 오후 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="kr">
<head>
    <%@ include file="/WEB-INF/jsp/include/header.jspf"%>
</head>
<body>
<%@ include file="/WEB-INF/jsp/include/navigation.jspf"%>
<div class="container" id="main">
    <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-default content-main">
            <table class="table table-bordered">
                <tr>
                    <th>회원코드</th>
                    <th>아이디</th>
                    <th>비밀번호</th>
                    <th>이름</th>
                    <th>이메일</th>
                </tr>
                <c:forEach items="${list}" var="customer">
                    <tr>
                        <td>${customer.customer_code}</td>
                        <td><a href='/customer/read?customer_id=${customer.customer_id}'>${customer.customer_id}</a></td>
                        <td>${customer.customer_pw}</td>
                        <td>${customer.customer_name}</td>
                        <td>${customer.customer_email}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
</body>
</html>

