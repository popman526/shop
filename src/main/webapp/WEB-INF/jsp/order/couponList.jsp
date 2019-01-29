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
<form id="couponListForm" name="couponListForm" method="post">
<div class="container" id="main">
   <div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
      <div class="panel panel-default content-main">
			<h2> MY쿠폰 조회 </h2>
			<table class="table table-bordered">
				<thead >
					<tr>
						<th>쿠폰명</th>
						<th>할인율</th>
						<th>유효기간</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody>
				<c:if test="${ couponList ne null }">
					<c:forEach var="coupon" items="${couponList}">
						<tr>
							<td>
								${coupon.coupon_name}
							</td>
							<td>
								${coupon.discount}
							</td>
							<td>
								${fn:substring(coupon.valid_date,0,4)}.${fn:substring(coupon.valid_date,4,6)}.${fn:substring(coupon.valid_date,6,8)} 
							</td>
							<td>
								${coupon.status}
							</td>
						</tr>	
					</c:forEach>
				</c:if>
				</tbody>
			</table>
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
</html>
