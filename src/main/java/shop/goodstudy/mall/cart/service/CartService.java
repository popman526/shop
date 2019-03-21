package shop.goodstudy.mall.cart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import shop.goodstudy.mall.cart.model.Cart;

@Transactional
public interface CartService {

	int create(Cart c);
	List<Cart> getList(String id);
	boolean delete(List<Long> products, String id);
	boolean updateCount(int count, long pid, String cid);
	boolean checkExist(long pid, String cid);
	boolean cartOrder(List<Long> products, String cid);
	List<Cart> getChecked(String id);
	
}//end of CartService
