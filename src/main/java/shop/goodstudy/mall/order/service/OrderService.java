package shop.goodstudy.mall.order.service;

import shop.goodstudy.mall.order.model.OrderDetailVO;
import shop.goodstudy.mall.order.model.OrderVO;

public interface OrderService {

	public int insertOrder(OrderVO order) throws Exception;
	public int deleteOrder(int order_id) throws Exception;
	public int deleteOrderDetail(int order_id) throws Exception;
	public int insertOrderDetail(OrderDetailVO order) throws Exception;
}
