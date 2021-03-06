<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="kr">
<head>
<link rel="stylesheet" type="text/css" href="/css/slide_style.css"  >
<%@ include file="/WEB-INF/jsp/include/header.jspf"%>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/include/navigation.jspf"%>
	
	
	<div class="slideshow-container"  >
		<c:forEach items="${sliderProduct}" var="each">
			<div class="mySlides">
				<img src="/image/downloadMainImage?product_id=${each.product_id}" id="slider_img"  width="100%", height="400" >
			</div>
		</c:forEach>
		<div><a class="prev" onclick="plusSlides(-1)">&#10094;</a> </div>
		<div><a class="next" onclick="plusSlides(1)">&#10095;</a></div>
	</div>
	<br>
	<div style="text-align: center">
		<span class="dot" onclick="currentSlide(1)"></span> 
		<span class="dot" onclick="currentSlide(2)"></span> 
		<span class="dot" onclick="currentSlide(3)"></span>
		<span class="dot" onclick="currentSlide(4)"></span>
		<span class="dot" onclick="currentSlide(5)"></span>
	</div>

	<div class="container" id="main">
		<div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
			<div class="panel panel-default qna-list">
			<br> <b>(전체 글:${count})</b>
			<div class="col-md-3 qna-write" style="float: right; padding-top: 0em">
				<a href="/product/form" class="btn btn-primary pull-right"
					role="button">상품등록</a>
			</div>
				<ul class="list">
					<c:if test="${count == 0 }">
						<li>
							<strong>게시된 상품이 없습니다. 상품을 올려주세요.</strong>
						</li>
					</c:if>
					<c:forEach items="${products}" var="each">
						<li>
							<div class="wrap">
								<div class="main">
									<strong class="subject"> <a
										href="/product/show?product_id=${each.product_id}&pageNum=${pageNum}">${each.product_name}</a>
									</strong>
									<div class="main_img" title="${each.product_name}">
										<a style="cursor: pointer;" class="btn-example"
											href="/product/show?product_id=${each.product_id}&pageNum=${pageNum}"> <img
											src="/image/downloadMainImage?product_id=${each.product_id}"
											id="main_img"></a>
									</div>
									<div class="auth-info">
										<i class="icon-add-comment"></i> <span class="time"><fmt:formatDate
												pattern="yyyy-MM-dd HH:mm:ss" value="${each.reg_dt}" /></span> <a
											href="#" class="author">${each.reg_id}</a>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6 text-center">
						<ul class="pagination center-block" style="display: inline-block;">
							<c:choose>
								<c:when test="${startPage < pageBlock }">
									<li><img src="/images/beforePage.png" width="35"></li>
								</c:when>
								<c:otherwise>
									<li><img src="/images/beforePage.png" width="35"
									 onclick="location.href=?pageNum=${startPage - pageBlock }" style="cursor:pointer"> </li>
								</c:otherwise>
							</c:choose>
							<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
								<c:choose>
									<c:when test="${i == pageNum }">
										&nbsp;&nbsp;<b><font color="#91B7EF">${i }</font></b>
									</c:when>
									<c:otherwise>
										&nbsp;&nbsp;<a href="/?pageNum=${i }">${i }</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${endPage < totalPage }">
									<li><img src="/images/afterPage.png"  width="35"
									 onclick="location.href=?pageNum=${startPage + pageBlock }" style="cursor:pointer"> </li>
								</c:when>
								<c:otherwise>
									<li><img src="/images/afterPage.png"  width="35"></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
					<div class="col-md-3 qna-write">
						<a href="/product/form" class="btn btn-primary pull-right"
							role="button">상품등록</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="rightSide">
		<div id="right_zzim">
			<div class="recTit">
				최근본상품 <span id=recentCnt></span>
			</div>
			<ul></ul>
			<!-- 본 상품이 뿌려질 부분  -->
			<div id="paging">
				<a class="btn_prev" style="cursor: pointer" title="이전"></a>
				<span id="currentPage"></span>
				<span id="totalPageCount"></span>
				<a class="btn_next" style="cursor: pointer" title="다음"></a>
			</div>
		</div>
	</div>


	<!--login modal-->
	<!--
<div id="loginModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h2 class="text-center"><img src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100" class="img-circle"><br>Login</h2>
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block">
              <div class="form-group">
                  <label for="customer_id">사용자 아이디</label>
                  <input class="form-control" name="customer_id" placeholder="Customer ID">
              </div>
              <div class="form-group">
                  <label for="customer_pw">비밀번호</label>
                  <input type="password" class="form-control" name="customer_pw" placeholder="Password">
              </div>
              <div class="form-group">
                  <button class="btn btn-primary btn-lg btn-block">로그인</button>
                  <span class="pull-right"><a href="#registerModal" role="button" data-toggle="modal">회원가입</a></span>
              </div>
          </form>
      </div>
      <div class="modal-footer">
          <div class="col-md-12">
          <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
      </div>
      </div>
  </div>
  </div>
</div>
-->

	<!--register modal-->
	<!--
<div id="registerModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h2 class="text-center"><img src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100" class="img-circle"><br>회원가입</h2>
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block">
              <div class="form-group">
                  <label for="customer_id">사용자 아이디</label>
                  <input class="form-control" id="customer_id" name="customer_id" placeholder="Customer ID">
              </div>
              <div class="form-group">
                  <label for="customer_pw">비밀번호</label>
                  <input type="password" class="form-control" id="customer_pw" name="customer_pw" placeholder="Password">
              </div>
              <div class="form-group">
                  <label for="name">이름</label>
                  <input class="form-control" id="name" name="name" placeholder="Name">
              </div>
              <div class="form-group">
                  <label for="email">이메일</label>
                  <input type="email" class="form-control" id="email" name="email" placeholder="Email">
              </div>
            <div class="form-group">
              <button class="btn btn-primary btn-lg btn-block">회원가입</button>
            </div>
          </form>
      </div>
      <div class="modal-footer">
          <div class="col-md-12">
          <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
      </div>
      </div>
  </div>
  </div>
</div>
-->

	<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
</body>
<script src="/js/cookie.js"></script>
<script src="/js/home.js"></script>
<script type="text/javascript">
	var slideIndex = 1;
	showSlides(slideIndex);
	autoslide = setInterval(function() { showSlides() }, 2000);
	
	function plusSlides(n) {
	    clearInterval(autoslide);
	    showSlides(slideIndex += n);
	    after();
	}

	function currentSlide(n) {
		clearInterval(autoslide);
		showSlides(slideIndex = n);
		after();
	}
	
	function after() {
           clearInterval(autoslide);  
           autoslide = setInterval(function() { showSlides() }, 2000);
    }

	function showSlides(n) {
	  if( typeof n == 'undefined') {
		  slideIndex ++;
		  n = slideIndex;
	  }	
	  
	  var i;
	  var slides = document.getElementsByClassName("mySlides");
	  var dots = document.getElementsByClassName("dot");
	  
	  if (n > slides.length) {slideIndex = 1}    
	  if (n < 1) {slideIndex = slides.length}
	  for (i = 0; i < slides.length; i++) {
	      slides[i].style.display = "none";  
	  }
	  for (i = 0; i < dots.length; i++) {
	    dots[i].className = dots[i].className.replace(" active", "");
	  }
	  slides[slideIndex-1].style.display = "block";  
	  dots[slideIndex-1].className += " active";
	} 
</script>

</html>