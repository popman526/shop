package shop.goodstudy.mall.cart.service;

import org.springframework.transaction.annotation.Transactional;

import shop.goodstudy.mall.cart.model.Cart;

@Transactional
public interface CartService {

	boolean create(Cart c);
	
}//end of CartService
