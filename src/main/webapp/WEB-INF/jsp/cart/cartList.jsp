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
						<tr>
							<td class = "img">
								<div class="article-images">
									<div class="main_img" title="메인이미지">
										<a style="cursor: pointer;" class="btn-example"
											href="/product/show?product_id=${cart.product_id}"> 
											<img src="/product/downloadThumbnail?product_id=${cart.product_id}" class="main_img1"></a>
									</div>
								</div>
								<span></span>
							</td>
							<td class = "name">
								${cart.product_name}
							</td>
							<td class = "buyCount">
								<input type = "hidden" class = "order_quantity" value = "${cart.order_quantity}">
								<div class = "loading">
									<img src = "/images/loading.gif">
								</div>
								<select name="order_quantity" class="buyCount" class="pull-right">
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
							<td class = "price">
								<input type = "hidden" class = "product_price" value = "${cart.product_price}">
								<span id = "total_price">${cart.total_price}원</span>
							</td>
							<td class = "id">
								<input type = "checkbox" name = "product_id" class = "product_id" value = "${cart.product_id}">
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

function findData(){
	var ary = $(".buyCount").children();
	for(var i = 0; i < ary.length; i++){
		if(ary[i].value == $(".order_quantity").val()){
			ary[i].selected = true;
		}
	}
}

$(document).ready(function(){
	
	$(".loading").hide();
	
	//체크박스에서 저장된 값 찾기
	findData();
	
	//변경 시 TotalPrice 찾기
	$(".buyCount").on('change',function(){
		
		var parent = $(this).parent().parent();
		console.log(parent.prop('tagName'));
		console.log(parent.children('.id').children('.product_id').val());
		
		var order_quantity = {
				'buyCount': $(this).val(),
				'product_id': parent.children('.product_id').val()
		};
		
		$.ajax({
			type:"put",
			url:"cart",
			data:order_quantity,
			success: function(data){
				var totalPrice = $("#product_price").val() * $("#buyCount").val();
				$("#total_price").text(totalPrice + "원");
				$("#order_quantity").val($("#buyCount").val());
			},
			error: function(data){
				findData();
			}
			
		});
		
	});
	
	//delete method로 삭제 전송하기
	$("#del").on('click',function(){
		
		$("#_method").val("delete");
		$("#cartForm").submit();
		
	});
	
});

</script>
</body>
</html>
