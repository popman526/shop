// recent item    
var Cpage; // 현재 페이지
var pagingSize = 4; // 원하는 페이지 사이즈로 조정하세용
function chkRecent(a) {
	var items = getCookie('productItems'); // 이미 저장된 값을 쿠키에서 가져오기
	$("#right_zzim ul").html(''); // 일단 Ul 내용 지우기...
	if (items) {
		var totcount = items.split(',').length; //
		var totpage = Math.ceil(totcount / pagingSize) * 1;
		Cpage = (totpage >= a) ? a : 1;
		Cpage = (Cpage < 1) ? totpage : Cpage;
		var start = (Cpage - 1) * pagingSize;
		for (i = start; i <= start + (pagingSize - 1); i++) {
			var thisItem = items.split(',')[i];
			if (thisItem) {
				$("#right_zzim ul")
						.append(
								'<li><a href="/product/show?product_id='
										+ thisItem
										+ '" target="_top"><img src="/product/downloadMainImage?product_id='
										+ thisItem
										+ '"  width="75" border=1></a><div class="detail"><a href="javascript:removeRecentItem(\''
										+ thisItem
										+ '\')" class="btn_delete" title="삭제"></a></div></li>')
			}
		}
		$("#paging").show();
	} else {
		$("#right_zzim ul").append('<p class="noData">최근 본 상품이<br> 없습니다.</p>');
		$("#paging").hide();
		$("#recentCnt").text('');
	}
	updateRecentPage(totcount, Cpage);
}

chkRecent(1);

function removeRecentItem(itemname) {
	var items = getCookie('productItems');
	var newItems = items.replace(itemname + ",", "");
	if (items == newItems) { //마지막 아이템은 다른 방법으로 삭제해야 함
		newItems = items.replace("," + itemname, "");
		setCookie('productItems', newItems, 7);
		if (items == newItems) { //1개만 남았을 때 모두 지우기
			document.cookie = 'productItems=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
		}
	}
	chkRecent(Cpage);
}

function updateRecentPage(totcount, Cpage) { //  
	$("#recentCnt").text(totcount); //
	$("#totalPageCount").text("/" + Math.ceil((totcount / pagingSize) * 1));
	if (Math.ceil((totcount / pagingSize) * 1) < Cpage) {
		$("#currentPage").text(Math.ceil((totcount / pagingSize) * 1));
	} else {
		$("#currentPage").text(Cpage); //
	}
}

$(".btn_next").on('click', function() {
	chkRecent(Cpage + 1);
});

$(".btn_prev").on('click', function() {
	chkRecent(Cpage - 1);
});
