<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="kr">
<head>
<%@ include file="/WEB-INF/jsp/include/header.jspf"%>
<style type="text/css">
table#product-files-write-table {
	width: 60%;
	display: inline;
}
table#product-info-write-table {
	display: inline;
	width: 30%;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/include/navigation.jspf"%>

	<div class="container" id="main">
		<div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
			<div class="panel panel-default content-main">
				<form name="product" method="post" action="/product/create"
					enctype="multipart/form-data">
					<table id="product-files-write-table">
						<tr>
							<td>
								<div id="line">
									<hr color="#0ECFB5">
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="file-list" align="center"
									style="width: 485px; height: 464px; overflow-y: scroll;">
									<div id="write-inform" style="width: 465px; height: 200px;"></div>
									미리보기
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="form-group">
									<label for="files">첨부파일</label> <input id="files-upload"
										name="file" type="file" multiple accept="image/*"> <font
										size="2"> *다수의 사진도 올릴 수 있습니다!</font>
								</div>
							</td>
						</tr>
					</table>
					<table id="product-info-write-table">
						<tr>
							<td>
								<div class="form-group">
									<label for="name">상품명</label> <input type="text" style="width: 400px;"
										class="form-control" id="name" name="name" placeholder="상품명" />
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="form-group">
									<label for="state">상품상태</label> <select name="state" id="state">
										<option value="1">판매중</option>
										<option value="2">임시등록</option>
										<option value="3">판매완료</option>
										<option value="4">판매중지</option>
										<option value="5">영구판매중지</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="form-group">
									<label for="price">상품가격</label> <input type="text"
										class="form-control" id="price" name="price"
										placeholder="상품가격" />
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<button type="submit"
									class="btn btn-success clearfix pull-right">상품등록</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/jsp/include/footer.jspf"%>
</body>
</html>