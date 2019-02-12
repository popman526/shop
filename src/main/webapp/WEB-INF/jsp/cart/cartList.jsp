<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/css/order_style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"-->
<head>
	<%@ include file="/WEB-INF/jsp/include/header.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/jsp/include/navigation.jspf" %>

<div class="container" id="main">
   <div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
      <div class="panel panel-default content-main">
      <form id = "cartForm" action = "cart" method = "post">
      		<input type = "hidden" id = "_method" name = "_method">
			<h2> 장바구니 </h2>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>상품</th>
						<th>상품명 </th>
						<th>수량</th>
						<th>최종가격</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cart" items="${cart}">
						<tr id = "${cart.cart_id}">
							<td>
								<div class="article-images">
									<div class="main_img" title="메인이미지">
										<a style="cursor: pointer;" class="btn-example"
											href="/product/show?product_id=${cart.product_id}"> 
											<img src="/product/downloadThumbnail?product_id=${cart.product_id}" class="main_img1"></a>
									</div>
								</div>
								<span></span>
							</td>
							<td>
								${cart.product_name}
							</td>
							<td>
								<input type = "hidden" id = "order_quantity" value = "${cart.order_quantity}">
								<select name="order_quantity" id="buyCount" class="pull-right"
									onchange="changePrice();">
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
								</select>
							</td>
							<td>
								<input type = "hidden" id = "product_price" value = "${cart.product_price}">
								<span id = "total_price">${cart.total_price}원</span>
							</td>
							<td>
								<input type = "checkbox" name = "product_id" value = "${cart.product_id}">
							</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
			<div>
				 <input type = "button" class = "btn btn-warning" id = "del" value = "장바구니 제거하기">
		         <a href = "<c:url value='/'/>">홈 화면으로 돌아가기</a>
		    </div>
		    </form>
		</div>
	</div>
</div>    
<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
<script>
$(document).ready(function(){
	
	var ary = $("#buyCount").children();
	for(var i = 0; i < ary.length; i++){
		if(ary[i].value == $("#order_quantity").val()){
			ary[i].selected = true;
		}
	}
	
	$("#buyCount").on('change',function(){
		var totalPrice = $("#product_price").val() * $("#order_quantity").val();
		$("#total_price").text(totalPrice + "원");
	});
	
	$("#del").on('click',function(){
		
		$("#_method").val("delete");
		$("#cartForm").submit();
		
	});
	
});
</script>
</body>
</html>
