function fn_delete(order_id){
    var form = document.getElementById("orderListForm");
    form.action = "/deleteOrder/" + order_id ;
    form.submit();
}