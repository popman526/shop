<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="kr">
<head>
<%@ include file="/WEB-INF/jsp/include/header.jspf"%>
<style type="text/css">
img.main_img {
	width: 30%;
	display: inline;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/include/navigation.jspf"%>

	<div class="container" id="main">
		<div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
			<div class="panel panel-default">
				<c:if test="${not empty errorMessage}">
					<div class="alert alert-danger" role="alert">${errorMessage}</div>
				</c:if>
				<header class="product-header">
					<h2 class="product-title">상품구매</h2>
				</header>
				<div class="content-main">
					<article class="article">
						<form action="/order/product" method="post" id = "orderForm"> <!-- 주문 action mapping -->
							<div class="article-header"></div>
							<div class="article-images">
								<div class="main_img" title="메인이미지">
									<a style="cursor: pointer;" class="btn-example"
										href="/product/show?product_id=${product.product_id}"> <img
										src="/image/downloadMainImage?product_id=${product.product_id}"
										id="main_img"></a>
								</div>
							</div>
							<div class="article-author-name">상품명: ${product.product_name }</div>
							<div class="article-author-name">구매수량: ${buyCount }</div>
							<div class="article-author-name">총가격: ${product.product_price }</div>
							<input type="hidden" name="order_quantity" value="${buyCount }"/>
							<input type="hidden" name="product_id" value="${product.product_id }"/>
							<input type="hidden" name="product_name" value="${product.product_name }"/>
							<input type="hidden" id = "product_price" name="product_price" value="${product.product_price }"/>
							<div><button type="button" class="pay btn btn-success clearfix pull-right">결제하기</button></div>
						</form>
					</article>
				</div>
			</div>
		</div>
	</div>

	<script type="text/template" id="answerTemplate">
	<article class="article">
		<div class="article-header">
			<div class="article-header-thumb">
				<img src="https://graph.facebook.com/v2.3/1324855987/picture" class="article-author-thumb" alt="">
			</div>
			<div class="article-header-text">
				{0}
				<div class="article-header-time">{1}</div>
			</div>
		</div>
		<div class="article-doc comment-doc">
			{2}
		</div>
		<div class="article-util">
		<ul class="article-util-list">
			<li>
				<a class="link-modify-article" href="/api/product/updateAnswer/{3}">수정</a>
			</li>
			<li>
				<form class="form-delete" action="/api/product/deleteAnswer" method="POST">
					<input type="hidden" name="answerId" value="{4}" />
					<button type="submit" class="link-delete-article">삭제</button>
				</form>
			</li>
		</ul>
		</div>
	</article>
</script>
<script src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript">
	var IMP = window.IMP;
	IMP.init("imp65623511");
	
	$(".pay").on('click',function(){
		
		var price = $("#product_price").val();
		
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
		    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
		    	jQuery.ajax({
		    		url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
		    		type: 'POST',
		    		dataType: 'json',
		    		data: {
			    		imp_uid : rsp.imp_uid
			    		//기타 필요한 데이터가 있으면 추가 전달
		    		}
		    	}).done(function(data) {
		    		//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
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
		    	
		    	$("#orderForm").submit();
		    	
		    } else {
		        var msg = '결제에 실패하였습니다.';
		        msg += '에러내용 : ' + rsp.error_msg;
		        
		        alert(msg);
		    }
		});
		
	});
	
</script>
	<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
</body>
</html>