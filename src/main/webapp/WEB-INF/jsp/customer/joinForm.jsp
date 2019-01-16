<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019-01-16
  Time: 오후 2:28
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
            <form name="question" method="post" action="/customer/join">
                <table class="table table-bordered table-hover"
                       style="text-align: center; border: 1px solid #dddddd">
                    <thead>
                    <tr>
                        <th colspan="3"><h4>회원 등록 양식</h4></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td style="width: 110px;"><h5>아이디</h5></td>
                        <td><input class="form-control" type="text"
                                   id="customer_id" name="customer_id" onkeydown="checkId()" maxLength="20"></td>
                        <td style="width: 110px;">
                    </tr>
                    <tr>
                        <td style="width: 110px;"><h5>비밀번호</h5></td>
                        <td colspan="2"><input class="form-control" type="password"
                                               id="customer_pw" name="customer_pw" maxLength="20"></td>
                    </tr>
                    <tr>
                        <td style="width: 110px;"><h5>비밀번호 확인</h5></td>
                        <td colspan="2"><input class="form-control" type="password"
                                               id="customer_pw2" name="customer_pw2" onkeyup="checkPwd()" maxLength="20"></td>
                    </tr>
                    <tr>
                        <td style="width: 110px;"><h5>이름</h5></td>
                        <td colspan="2"><input class="form-control" type="text"
                                               id="customer_name" name="customer_name" onkeydown="checkName()" maxLength="20"></td>
                    </tr>
                    <tr>
                        <td style="width: 110px;"><h5>이메일</h5></td>
                        <td colspan="2"><input class="form-control" type="email"
                                               id="customer_email" name="customer_email" onkeydown="checkEmail()" maxLength="20"></td>
                    </tr>
                    <tr>
                        <td style="text-align: left" colspan="3"><input
                                class="btn btn-primary pull-right" type="submit" value="회원가입"></td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
</body>
</html>

