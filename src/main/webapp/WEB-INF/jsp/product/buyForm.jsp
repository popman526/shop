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
						<form action="/order/product" method="post"> <!-- 주문 action mapping -->
							<div class="article-header"></div>
							<div class="article-images">
								<div class="main_img" title="메인이미지">
									<a style="cursor: pointer;" class="btn-example"
										href="/product/show?product_id=${product.product_id}"> <img
										src="/product/downloadMainImage?product_id=${product.product_id}"
										id="main_img"></a>
								</div>
							</div>
							<div class="article-author-name">상품명: ${product.product_name }</div>
							<div class="article-author-name">구매수량: ${buyCount }</div>
							<div class="article-author-name">총가격: ${product.product_price }</div>
							<div><button type="submit" class="btn btn-success clearfix pull-right">결제하기</button></div>
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
	<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
</body>
</html>