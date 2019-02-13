package shop.goodstudy.mall.cart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import shop.goodstudy.mall.cart.model.Cart;

@Transactional
public interface CartService {

	boolean create(Cart c);
	List<Cart> getList(String id);
	boolean delete(List<Long> products, String id);
	
}//end of CartService
