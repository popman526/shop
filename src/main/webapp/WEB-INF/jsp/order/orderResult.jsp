<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"-->
<head>
	<%@ include file="/WEB-INF/jsp/include/header.jspf" %>
<style type="text/css">
 img.main_img {
	width: 100px; 
	display: inline;
 }
 .title_center { margin:auto; text-align:center; }
 img.cart {
	width: 120px; 
	display: block;
	margin-left: auto;
	margin-right: auto;
 }
</style>
</head>
<body>
<%@ include file="/WEB-INF/jsp/include/navigation.jspf" %>

<form id="orderListForm" name="orderListForm" method="post">

<div class="container" id="main">
   <div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
      <div class="panel panel-default content-main">
      		<img src="/images/cart.png" class="cart"></a>
			<div class="title_center"><h3> 주문이 완료되었습니다! </h3></div>
			<br>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>상품</th>
						<th>상품명 </th>
						<th>수량</th>
						<th>최총가격</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${orderList}">
						<tr>
							<td>
								<div class="article-images">
									<div class="main_img" title="메인이미지">
										<a style="cursor: pointer;" class="btn-example"
											href="/product/show?product_id=${order.product_id}"> 
											<img src="/product/downloadMainImage?product_id=${order.product_id}" class="main_img"></a>
									</div>
								</div>
								<span></span>
							</td>
							<td>
								${order.product_name}
							</td>
							<td>
								${order.order_quantity}
							</td>
							<td>
								${order.product_price}
							</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>    
</form>
<script>
</script>
<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
</body>
</html>
