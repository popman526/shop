<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/css/order_style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<%@ include file="/WEB-INF/jsp/include/header.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/jsp/include/navigation.jspf" %>
<form id="couponZone" name="couponZone" method="post">
<div class="container" id="main">
   <div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
      <div class="panel panel-default content-main">
			<h2> 쿠폰존 </h2>
			<div>
				<a><img src="/images/coupon10per.png"  onclick="javascript:getCoupon('10','P');"></a>
			</div>
			<input type ="hidden" id ="coupon_id" name ="coupon_id"  />
			<input type ="hidden" id ="coupon_type" name ="coupon_type"  /> 
			<div>
		         <a href = "<c:url value='/'/>">홈 화면으로 돌아가기</a>
		    </div>
		</div>
	</div>
</div>    
</form>
<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
</body>
<script src="/js/order/order.js"></script>
<script>
$(document).ready(function(){
	var list = new Array(); 
	<c:forEach items="${result}" var="result">
		list.push("${result}");
	</c:forEach>
	
	if( list != '') {
		alert(list);
	}
})

function getCoupon(coupon_id, coupon_type) {
	//alert("getCoupon , " + coupon_id);
	$("#coupon_id").val(coupon_id);
	$("#coupon_type").val(coupon_type);
	
	var form = document.getElementById("couponZone");
    form.action = "/coupon/getCoupon" ;
    form.submit();
}
</script>
</html>
