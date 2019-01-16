<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019-01-16
  Time: 오후 2:33
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
            <form role="form" method="post" class="role">
                <input type='hidden' name='customer_id'
                       value="${customerVO.customer_id}">
            </form>

            <div class="box-body">
                <div class="form-group">
                    <label for="exampleInputEmail1">아이디</label> <input type="text"
                                                                       name="customer_id" class="form-control"
                                                                       value="${customerVO.customer_id}" readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">비밀번호</label> <input type="text"
                                                                           name="customer_pw" class="form-control"
                                                                           value="${customerVO.customer_pw}" readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">이름</label> <input type="text"
                                                                      name="customer_name" class="form-control"
                                                                      value="${customerVO.customer_name}" readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">이메일</label> <input type="text"
                                                                       name="customer_email" class="form-control"
                                                                       value="${customerVO.customer_email}" readonly="readonly">
                </div>
            </div>
            <!-- /.box-body -->

            <div class="box-footer">
                <button type="submit" class="btn btn-warning">수정</button>
                <button type="submit" class="btn btn-danger">탈퇴</button>
            </div>
        </div>
    </div>
</div>
<script>
    const warning_btn = document.querySelector(".btn-warning");
    const danger_btn = document.querySelector(".btn-danger");

    var formObj = document.querySelector(".role");

    function toModify() {
        formObj.setAttribute("action", "/customer/modify");
        formObj.setAttribute("method", "get");
        formObj.submit();
    }

    function toRemove() {
        formObj.setAttribute("action", "/customer/remove");
        formObj.submit();
    }

    function init() {
        warning_btn.addEventListener("click", toModify);
        danger_btn.addEventListener("click", toRemove);
    }

    init();
</script>
<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
</body>
</html>
