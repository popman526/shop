package shop.goodstudy.mall.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.goodstudy.mall.order.mapper.OrderMapper;
import shop.goodstudy.mall.order.model.OrderDetailVO;
import shop.goodstudy.mall.order.model.OrderVO;
import shop.goodstudy.mall.order.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderMapper orderMapper;
	
	public int insertOrder(OrderVO order) throws Exception {
		return orderMapper.insertOrder(order);
	}
	
	public int insertOrderDetail(OrderDetailVO order) throws Exception {
		return orderMapper.insertOrderDetail(order);
	}

	public int deleteOrder(int order_id) throws Exception {
		return orderMapper.deleteOrder(order_id);
	}
	
	public int deleteOrderDetail(int order_id) throws Exception {
		return orderMapper.deleteOrderDetail(order_id);
	}
}
