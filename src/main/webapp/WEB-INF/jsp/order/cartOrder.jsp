<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"-->
<head>
<%@ include file="/WEB-INF/jsp/include/header.jspf"%>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/include/navigation.jspf"%>

	<div class="container" id="main">
		<div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
			<div class="panel panel-default content-main">
				<form id="cartForm" action="/order" method="post">
					<input type="hidden" id="_method" name="_method">
					<h2>장바구니</h2>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>상품</th>
								<th>상품명</th>
								<th>수량</th>
								<th>최종가격</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="cart" items="${cart}">
								<tr>
									<td class="img">
									<input type="hidden" name="cart_id" value="${cart.cart_id}">
										<div class="article-images">
											<div class="main_img" title="메인이미지">
												<a style="cursor: pointer;" class="btn-example"
													href="/product/show?product_id=${cart.product_id}"> <img
													src="/product/downloadThumbnail?product_id=${cart.product_id}"
													class="main_img1"></a>
											</div>
										</div>
									</td>
									<td class="name">${cart.product_name}</td>
									<td class="count">${cart.order_quantity}
										</td>
									<td class="price"> <span
										class="total_price">${cart.total_price}</span>원</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div>
						<input type="hidden" id="tot" name="total">
						<h1>총 가격: <span id = "total">${total}</span>원</h1>
						<button type="button" class="btn btn-success" id="get_order">주문하기</button>
						<a href="<c:url value='/'/>">홈 화면으로 돌아가기</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
	<script src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script type="text/javascript">
	
	$('#tot').val($('#total').text());
	
	var IMP = window.IMP;
	IMP.init("imp65623511");
	
	$("#get_order").on('click',function(){
		
		var price = $("#total").text();
		
		IMP.request_pay({
		    pg : 'kakaopay',
		    pay_method : 'card',
		    merchant_uid : 'merchant_' + new Date().getTime(),
		    name : '결제테스트',
		    amount : price,
		    buyer_email : 'iamport@siot.do',
		    buyer_name : '구매자이름',
		    buyer_tel : '010-1234-5678',
		    buyer_addr : '서울특별시 강남구 삼성동',
		    buyer_postcode : '123-456'
		}, function(rsp) {
		    if ( rsp.success ) {
		    	jQuery.ajax({
		    		url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
		    		type: 'POST',
		    		dataType: 'json',
		    		data: {
			    		imp_uid : rsp.imp_uid
		    		}
		    	}).done(function(data) {
		    		if ( everythings_fine ) {
		    			var msg = '결제가 완료되었습니다.';
		    			msg += '\n고유ID : ' + rsp.imp_uid;
		    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
		    			msg += '\결제 금액 : ' + rsp.paid_amount;
		    			msg += '카드 승인번호 : ' + rsp.apply_num;
		    			
		    			alert(msg);
		    		} else {
		    		}
		    	});
		    	
		    	$("#cartForm").submit();
		    	
		    } else {
		        var msg = '결제에 실패하였습니다.';
		        msg += '에러내용 : ' + rsp.error_msg;
		        
		        alert(msg);
		    }
		});
		
	});
	
</script>
</body>
</html>