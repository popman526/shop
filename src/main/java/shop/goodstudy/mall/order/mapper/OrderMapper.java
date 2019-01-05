package shop.goodstudy.mall.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.order.model.OrderDetailVO;
import shop.goodstudy.mall.order.model.OrderVO;

@Mapper
public interface OrderMapper {
	
	public int insertOrder(OrderVO order) throws Exception;
	public int insertOrderDetail(OrderDetailVO order) throws Exception;
	public List<OrderVO> selectOrder() throws Exception;
	public int deleteOrder(int order_id) throws Exception;
	public int deleteOrderDetail(int order_id) throws Exception;
}
