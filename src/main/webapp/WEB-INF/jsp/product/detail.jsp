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
						<form action="cart" method="post" id = "cartForm"> <!-- 주문 action mapping -->
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
							<input type = "hidden" name = "customerCode" value = "${customerCode}">
							<input type="hidden" name="orderQuantity" value="${buyCount }"/>
							<input type="hidden" name="productId" value="${product.product_id }"/>
							<div><button type="submit" class="btn btn-success clearfix pull-right">장바구니 담기</button></div>
						</form>
					</article>
				</div>
			</div>
		</div>
	</div>
<script src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
</body>
</html>