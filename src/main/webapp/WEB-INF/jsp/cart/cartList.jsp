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
				<form id="cartForm" action="cart/order" method="post">
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
										<div class="article-images">
											<div class="main_img" title="메인이미지">
												<a style="cursor: pointer;" class="btn-example"
													href="/product/show?product_id=${cart.product_id}"> <img
													src="/product/downloadThumbnail?product_id=${cart.product_id}"
													class="main_img1"></a>
											</div>
										</div> <span></span>
									</td>
									<td class="name">${cart.product_name}</td>
									<td class="count"><input type="hidden"
										class="order_quantity" value="${cart.order_quantity}">
										<select name="order_quantity" class="buyCount"
										class="pull-right">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
									</select></td>
									<td class="price"><input type="hidden"
										class="product_price" value="${cart.product_price}"> <span
										class="total_price">${cart.total_price}</span>원</td>
									<td class="id"><input type="checkbox" name="product_id"
										class="product_id" value="${cart.product_id}"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div>
						<input type="button" class="btn btn-warning" id="del"
							value="장바구니 제거하기">
						<button type="button" class="btn btn-success" id="get_order">주문하기</button>
						<a href="<c:url value='/'/>">홈 화면으로 돌아가기</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
	<script type="text/javascript"
		src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script>
		var initial = true;

		// 초기화 - 장바구니 데이터 담기 & 체크 박스 수정
		function init() {
			//체크박스에서 저장된 값 찾기
			for (var i = 0; i < $('tbody').children().length; i++)
				checkData($('tbody').children()[i]);
			initial = false;
		}
		
		// 체크 박스 내에 지정된 값 변경하기
		function checkData(element) {
			element.getElementsByClassName("buyCount")[0].value = element
					.getElementsByClassName("order_quantity")[0].value;
		}

		init();

		// 주문 데이터 넘기기
		$("#get_order").on('click', function() {
			
			$('#cartForm').submit();
			
		});

		//변경 시 TotalPrice 찾기
		$(".buyCount").on('change', function() {

			var parent = $(this).parent().parent();
			var count = $(this).val();

			var order_quantity = {
				'buyCount' : count,
				'product_id' : parent.find('.product_id').val()
			};

			if(!initial){
				$.ajax({
					type : 'put',
					url : 'cart',
					data : order_quantity,
					success : function(data) {
					parent.find('.order_quantity').val(count + '');
					},
					error : function(data) {
						alert('정보 수정에 실패했습니다.');
						checkData(parent[0]);
					}

				});
			}

		});

		//delete method로 삭제 전송하기
		$("#del").on('click', function() {

			$("#_method").val("delete");
			$("#cartForm").submit();

		});
	</script>
</body>
</html>
