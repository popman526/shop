package shop.goodstudy.mall.cart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import shop.goodstudy.mall.cart.model.Cart;
import shop.goodstudy.mall.product.model.Product;

@Transactional
public interface CartService {

	boolean create(Cart c);
	List<Cart> getList(String id);
	
}//end of CartService
