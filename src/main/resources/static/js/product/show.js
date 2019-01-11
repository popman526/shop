function basket() {
	var product_id = document.getElementById("product_id").value;
	var product_name = document.getElementById("product_name").value;
	var buyCount = document.getElementById("buyCount").value;

	alert("장바구니에 담았습니다!!\n상품id: "+product_id+"\n상품명: "+product_name+"\n구매수량: "+buyCount);
	
	//임시로 상품상세화면을 다시 불러오게 함.
	//장바구니 기능을 구현한 후 아래 내용은 삭제할 것.
	//장바구니ex) 구매 화면으로 간다 / 계속 쇼핑하기
	var form=document.buyForm;
	form.method = "get";
	form.action = "/product/show?product_id=" + product_id;
	form.submit();
}

function buyProduct() {
	var customerId = document.getElementById("customerId").value;
	var form=document.buyForm;
	if (customerId == "") {
		alert("로그인이 필요합니다.\n로그인화면으로 이동합니다.");
		form.method = "get";
		form.action = "/customer/loginForm";
	} else {
		form.action = "/product/buy";
	}
	form.submit();
}

function changeBuyCountSelect() {
	var product_price = document.getElementById("temp_product_price").value;
	var buyCount = document.getElementById("buyCount").value;
	
	var totalPrice = product_price * buyCount;
	document.getElementById("product_price").value = totalPrice;
}
