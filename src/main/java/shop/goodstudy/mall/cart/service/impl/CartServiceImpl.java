package shop.goodstudy.mall.cart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.goodstudy.mall.cart.mapper.CartMapper;
import shop.goodstudy.mall.cart.model.Cart;
import shop.goodstudy.mall.cart.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired private CartMapper cartMapper;
	
	public boolean create(Cart c) {
		return cartMapper.create(c) > 0 ? true: false;
	}

}
