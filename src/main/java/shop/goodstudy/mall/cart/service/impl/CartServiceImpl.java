package shop.goodstudy.mall.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.goodstudy.mall.cart.mapper.CartMapper;
import shop.goodstudy.mall.cart.model.Cart;
import shop.goodstudy.mall.cart.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;

	public int create(Cart c) {
		return cartMapper.create(c);
	}

	public List<Cart> getList(String id) {
		return cartMapper.getList(id);
	}

	public boolean delete(List<Long> products, String id) {

		boolean result = false;

		for (int i = 0; i < products.size(); i++) {
			result = cartMapper.delete(new Cart().builder().product_id(products.get(i)).customer_id(id).build()) > 0;
			if (!result)
				return false;
		}

		return result;

	}

	@Override
	public boolean updateCount(int count, long pid, String cid) {
		return cartMapper
				.updateCount(new Cart().builder().product_id(pid).customer_id(cid).order_quantity(count).build()) > 0;
	}

	@Override
	public boolean checkExist(long pid, String cid) {
		return cartMapper.checkExist(new Cart().builder().product_id(pid).customer_id(cid).build()) > 0;
	}

	@Override
	public boolean cartOrder(List<Long> products, String cid) {
		boolean result = false;

		for (int i = 0; i < products.size(); i++) {
			result = cartMapper
					.updateChecked(new Cart().builder().product_id(products.get(i)).customer_id(cid).build()) > 0;
			if (!result)
				return false;
		}

		return result;
	}
	
	@Override
	public List<Cart> getChecked(String id){
		return cartMapper.getChecked(id);
	}

}
