function basket() {
	
	var total = parseInt($("#final_price").val());
	
	var cart = {
			"customer_id": $("#customer_id").val(),
			"product_id": $("#product_id").val(),
			"order_quantity": $("#buyCount").val(),
			"product_name": $("#product_name").val(),
			"product_price": $("#temp_product_price").val(),
			"total_price": $("#product_price").val()
	};
	
	$.ajax({
		type: 'post',
		url: '/cart',
		data: cart,
		dataType: 'json',
		error: function(xhr, status, error){
            alert('장바구니 담기에 실패했습니다.');
        },
        success: function(data){
        	if(data == 1){
        		$("#cartModal").modal();
        	}else if(data == -1){
        		alert('이미 장바구니에 있는 상품입니다.');
        	}else if(data == 0){
        		alert('장바구니 담기에 실패했습니다.');
        	}
        }
        
	});
	
}

function buyProduct() {
	var customerId = document.getElementById("customerId").value;
	var form=document.buyForm;
	if (customerId == "") {
		alert("로그인이 필요합니다.\n로그인화면으로 이동합니다.");
		form.method = "get";
		form.action = "/customer/loginForm";
	} else {
		form.method = "post";
		form.action = "/product/buy";
	}
	form.submit();
}

function changeBuyCountSelect() {
	var product_price = document.getElementById("temp_product_price").value;
	var buyCount = document.getElementById("buyCount").value;
	
	var totalPrice = product_price * buyCount;
	document.getElementById("product_price").value = totalPrice;
	
	// 쿠폰적용된 최종가격 계산
	setFinalPriceWithCoupon();
}

addCookie(document.getElementById("product_id").value);

function getCart(){
	location.href="/cart";
}