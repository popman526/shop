package shop.goodstudy.mall.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.goodstudy.mall.cart.mapper.CartMapper;
import shop.goodstudy.mall.cart.model.Cart;
import shop.goodstudy.mall.cart.service.CartService;
import shop.goodstudy.mall.product.mapper.ProductMapper;
import shop.goodstudy.mall.product.model.Product;

@Service
public class CartServiceImpl implements CartService{

	@Autowired private CartMapper cartMapper;
	@Autowired private ProductMapper productMapper;
	
	public boolean create(Cart c) {
		return cartMapper.create(c) > 0 ? true: false;
	}
		
	public List<Product> getList(String id){
		return productMapper.getCartList(id);
	}

}
