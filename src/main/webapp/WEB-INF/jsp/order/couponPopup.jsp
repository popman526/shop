<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/css/order_style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<%@ include file="/WEB-INF/jsp/include/header.jspf"%>
<style type="text/css">
.btn_cen {
	text-align: center
}
</style>
</head>
<body>
	<form id="couponListForm" name="couponListForm" method="post">
		<div class="container" id="main">
			<div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
				<div class="panel panel-default content-main">
					<h2>MY쿠폰 조회</h2>
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th></th>
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
										<td><input type="radio" name="user_CheckBox" /></td>
										<td>${coupon.coupon_name}</td>
										<td>${coupon.discount}</td>
										<td>
											${fn:substring(coupon.valid_date,0,4)}.${fn:substring(coupon.valid_date,4,6)}.${fn:substring(coupon.valid_date,6,8)}
										</td>
										<td>${coupon.status}</td>
									</tr>
								</c:forEach>

							</c:if>
						</tbody>
					</table>
					
					<div class="btn_cen">
						<button class="btn btn-primary" id="selectBtn">선택</button>
						<button class="btn btn-primary" onClick="window.close()">닫기</button>
					</div>
				</div>
			</div>
		</div>
	</form>
<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
</body>
<script type="text/javascript">
	//상단 선택버튼 클릭시 체크된 Row의 값을 가져온다.
	$("#selectBtn").click(function() {

		var rowData = new Array();
		var tdArr = new Array();
		var checkbox = $("input[name=user_CheckBox]:checked");
		var coupon_name = null;
		var discount = null;
		var valid_date = null;
		var status = null;

		// 체크된 체크박스 값을 가져온다
		checkbox.each(function(i) {

			// checkbox.parent() : checkbox의 부모는 <td>이다.
			// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();

			// 체크된 row의 모든 값을 배열에 담는다.
			rowData.push(tr.text());

			// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
			coupon_name = td.eq(1).text();  
			discount = td.eq(2).text(); 
			valid_date = td.eq(3).text() ;
			status = td.eq(4).text();

			// 가져온 값을 배열에 담는다.
			tdArr.push(coupon_name);
			tdArr.push(discount);
			tdArr.push(valid_date);
			tdArr.push(status);
		});
		
		sendCouponValue( coupon_name, discount);
	});
	
	function sendCouponValue(coupon_name, discount) {
		opener.setCouponValue(coupon_name, discount);
		window.close();
	}
	
</script>
<script src="/js/order/order.js"></script>
</html>
