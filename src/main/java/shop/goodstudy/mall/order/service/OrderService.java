package shop.goodstudy.mall.order.service;

import shop.goodstudy.mall.order.model.CouponVO;
import shop.goodstudy.mall.order.model.OrderDetailVO;
import shop.goodstudy.mall.order.model.OrderVO;

public interface OrderService {

	public int insertOrder(OrderVO order) throws Exception;
	public int deleteOrder(int order_id) throws Exception;
	public int deleteOrderDetail(int order_id) throws Exception;
	public int deleteOrderAndDetail(int order_id) throws Exception;
	public int insertOrderDetail(OrderDetailVO order) throws Exception;
	public int insertOrderAndDetail( OrderVO order, OrderDetailVO orderDetail) throws Exception;
	
	public int insertCoupon(CouponVO coupon) throws Exception;
}
