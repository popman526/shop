
# 주문기능 구현
  
## 1.	주문 기능 구현
* 홈 화면: 상품 리스트를 DB에서 모두 읽어온 후 home.jsp 뷰에 전달한다.  
shop.goodstudy.mall 패키지 내 아래와 같이 구성  
	- controller: OrderListController (결제화면에서 결제버튼 클릭시에 상품주문)  
	- order.mapper: OrderMapper
	- order.model: Order (주문 VO)  
	- order.service: OrderService (인터페이스)  
	- order.service.impl: OrderServiceImpl (주문 생성 및 삭제)  
  
  
  
  
