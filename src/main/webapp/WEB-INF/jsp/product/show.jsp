<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="kr">
<head>
<%@ include file="/WEB-INF/jsp/include/header.jspf"%>
<style>
   .fs_15 { font-size: 15px; }
 </style>
</head>
<body onload="setFinalPriceWithCoupon();">
	<%@ include file="/WEB-INF/jsp/include/navigation.jspf"%>

	<input type="hidden" id="customerId" name="customerId"
		value="${customer.customer_id}">

	<div class="container" id="main">
		<div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
			<div class="panel panel-default">
				<c:if test="${not empty errorMessage}">
					<div class="alert alert-danger" role="alert">${errorMessage}</div>
				</c:if>
				<header class="product-header">
					<h2 class="product-title">${product.product_name}</h2>
				</header>
				<div class="content-main">
					<article class="article">
						<div class="article-header"></div>
						<div class="article-util">
							<ul class="article-util-list">
								<c:if test="${customer.customer_id eq product.reg_id}">
									<li><a class="link-modify-article"
										href="/product/updateForm?product_id=${product.product_id}">수정</a>
									</li>
									<li>
										<form class="form-delete" action="/product/delete"
											method="POST">
											<input type="hidden" name="product_id"
												value="${product.product_id}" />
											<button class="link-delete-article" type="submit">삭제</button>
										</form>
									</li>
								</c:if>
								<li><a class="link-modify-article" href="/?pageNum=${pageNum }">목록</a></li>
							</ul>
						</div>
						<div class="article-images">
							<c:forEach items="${images}" var="each">
								<article class="article">
									<div class="article-img">
										<img
											src="/image/downloadContentImage?image_id=${each.image_id}"
											id="article-img">
									</div>
								</article>
							</c:forEach>
						</div>
						<div>
							<form name="buyForm" >
								<input type = "hidden" id = "customer_id" name = "customer_id" value = "${customer.customer_id}">
								<input type="hidden" id="product_id" name="product_id"
									value="${product.product_id}"> 
								<input type="hidden"
									id="product_name" name="product_name"
									value="${product.product_name}"> <input type="hidden"
									id="temp_product_price" value="${product.product_price}">
								<button id="basket-button" type = "button"
									class="btn btn-success clearfix pull-right" onclick="basket();">장바구니</button>
								<button id="buyProduct-button"
									class="btn btn-success clearfix pull-right"
									onclick="buyProduct();">상품구입</button>
								<div class="article-author-name pull-right">|</div>
								<input type="text" value="${product.product_price }"
									class="article-author-name pull-right" id="product_price"
									name="product_price" readonly="readonly">
								<div class="article-author-name pull-right">가격</div>
								<div class="article-author-name pull-right">|</div>
								<select name="buyCount" id="buyCount" class="pull-right"
									onchange="changeBuyCountSelect();">
									<option value="1" selected="selected">1</option>
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
								<div class="article-author-name pull-right">수량</div>
								<input type="hidden" id="hidden_finalPrice" name="hidden_finalPrice" />
							</form>
						</div>
					</article>
					<input type="hidden" id="hidden_coupon_name" name="coupon_name"  >
					<input type="hidden" id="hidden_discount" name="discount"  >
					<table>
						<tr>
							<td>
								<div>
									<button class="btn btn-primary clearfix pull-left" onclick="couponApply();">쿠폰적용</button>
								</div>
							</td>
							<td>
								<div>
									<button id="coupon_del" style="display: none;" class="btn btn-primary clearfix pull-left" onclick="couponDelete();">쿠폰삭제</button>
								</div>
							</td>
							<td>
								<div id="couponName"></div>
							</td>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="fs_15"><font color="blue">최종가격:</font></label> &nbsp;&nbsp;
							</td>
							<td>
								<div id="finalPrice"></div>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
	<div id="cartModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
      </div>
      <div class="modal-body">
      	<p><strong>장바구니 담기에 성공하셨습니다! 장바구니로 바로 가시겠습니까?</strong></p>
      </div>
      <div class="modal-footer">
          <div class="col-md-12">
          <button class="btn" onClick = "getCart()">예</button>
          <button class="btn" data-dismiss="modal" aria-hidden="true">아니오</button>
      	  </div>
      </div>
  </div>
  </div>
</div>
</body>
<script src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script src = "/js/bootstrap.min.js"></script>
<script src="/js/cookie.js"></script>
<script src="/js/product/show.js"></script>
<script src="/js/order/order.js"></script>
</html>