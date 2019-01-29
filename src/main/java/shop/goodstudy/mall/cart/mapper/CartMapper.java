package shop.goodstudy.mall.cart.mapper;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.cart.model.Cart;

@Mapper
public interface CartMapper {

	int create(Cart c);
	
}
