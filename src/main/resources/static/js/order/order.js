function fn_delete(order_id){
	
    var form = document.getElementById("orderListForm");
    form.action = "/deleteOrder/" + order_id ;
    form.submit();
}

function couponApply() {
	var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)

	window.open("/coupon/couponList","",popOption);
}

function couponDelete() {
	var product_price = document.getElementById("temp_product_price").value;
	var buyCount = document.getElementById("buyCount").value;
	var totalPrice = product_price * buyCount;
	//var discount = document.getElementById("hidden_discount").value;
	
	// 쿠폰값 원복
    document.getElementById("couponName").innerHTML = '';
    document.getElementById("hidden_coupon_name").value = '';
	document.getElementById("hidden_discount").value = '';
    
    // 최종가격 원복
    document.getElementById("finalPrice").innerHTML = totalPrice;
    
    
    // 쿠폰삭제 버튼 display
    toggleCouponDelBtn();
}

function toggleCouponDelBtn() {
	if( document.getElementById("hidden_discount").value != '' ){
		document.getElementById("coupon_del").style.display = "";
	} else {
		document.getElementById("coupon_del").style.display = "none";
	}
}

function couponApply() {
	
	// 가격 원복
	// document.getElementById("finalPrice").value = document.getElementById("product_price").value;
	
	var screenW = screen.availWidth;  // 스크린 가로사이즈
	var screenH = screen.availHeight; // 스크린 세로사이즈
	var width ='700', height='550';
	var left=( screenW-width ) / 2;   // 띄울창의 가로 포지션 
	var top=( screenH-height ) / 2;   // 띄울창의 세로 포지션 
	var popOption = "width="+ width +", height="+ height +", left="+ left +", top="+ top +", resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
	window.open("/coupon/couponPopup","",popOption);
	
}

function setFinalPriceWithCoupon() {
	var product_price = document.getElementById("temp_product_price").value;
	var buyCount = document.getElementById("buyCount").value;
	var totalPrice = product_price * buyCount;
	var discount = document.getElementById("hidden_discount").value;
	
    document.getElementById("couponName").innerHTML = document.getElementById("hidden_coupon_name").value;
    document.getElementById("finalPrice").innerHTML = totalPrice - Math.floor(totalPrice * (discount/ 100)) ;
    document.getElementById("hidden_finalPrice").value = totalPrice - Math.floor(totalPrice * (discount/ 100)) ;
}

function setCouponValue(coupon_name, discount){
	document.getElementById("hidden_coupon_name").value = coupon_name;
	document.getElementById("hidden_discount").value = discount;
	
	// 쿠폰적용된 최종가격 계산
	setFinalPriceWithCoupon();
	// 쿠폰삭제 버튼 display
    toggleCouponDelBtn();
}
