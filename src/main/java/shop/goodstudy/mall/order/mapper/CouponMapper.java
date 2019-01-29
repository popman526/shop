package shop.goodstudy.mall.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.order.model.CouponVO;

@Mapper
public interface CouponMapper {
	
	public List<CouponVO> selectAllCoupon(String customer_id) throws Exception;
}