package shop.goodstudy.mall.cart.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.goodstudy.mall.cart.model.Cart;
import shop.goodstudy.mall.cart.service.CartService;

@RestController
public class CartRestController {

	@Autowired private CartService cartService;
	
	/** 카트에 등록 **/
	@PostMapping("cart")
	public boolean postCart(@ModelAttribute Cart c) {
		return cartService.create(c);
	}
	
}
