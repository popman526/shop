<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019-01-16
  Time: 오후 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="kr">
<head>
    <%@ include file="/WEB-INF/jsp/include/header.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/jsp/include/navigation.jspf" %>
<div class="container" id="main">
    <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-default content-main">
            <form role="form" method="post" class="role">

                <div class="box-body">
                    <div class="form-group">
                        <label for="customer_id">아이디</label> <input type="text"
                                                                    name="customer_id" class="form-control"
                                                                    value="${customerVO.customer_id}"
                                                                    readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label for="customer_pw">비밀번호</label> <input type="text"
                                                                     name="customer_pw" class="form-control"
                                                                     value="${customerVO.customer_pw}">
                    </div>
                    <div class="form-group">
                        <label for="customer_name">이름</label> <input type="text"
                                                                     name="customer_name" class="form-control"
                                                                     value="${customerVO.customer_name}">
                    </div>
                    <div class="form-group">
                        <label for="customer_email">이메일</label> <input type="text"
                                                                       name="customer_email" class="form-control"
                                                                       value="${customerVO.customer_email}">
                    </div>
                </div>
            </form>
            <div class="box-footer">
                <button type="submit" class="btn btn-primary">저장</button>
                <button type="submit" class="btn btn-warning">취소</button>
            </div>
            <!-- /.box-body -->

        </div>
    </div>
</div>
<script>
    const primary_btn = document.querySelector(".btn-primary");
    const warning_btn = document.querySelector(".btn-warning");

    var formObj = document.querySelector(".role");

    function save() {
        console.log("save");
        formObj.setAttribute("action", "/customer/listAll");
        formObj.submit();
    }

    function cancel() {
        self.location = "/";
    }

    function init() {
        console.log(formObj);
        primary_btn.addEventListener("click", save);
        warning_btn.addEventListener("click", cancel);
    }

    init();
</script>
<%@ include file="/WEB-INF/jsp/include/footer.jspf" %>
</body>
</html>
