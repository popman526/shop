package shop.goodstudy.mall.cart.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import shop.goodstudy.mall.cart.model.Cart;
import shop.goodstudy.mall.cart.service.CartService;
import shop.goodstudy.mall.customer.model.Customer;
import shop.goodstudy.mall.product.model.Product;

@RestController
public class CartRestController {

	@Autowired private CartService cartService;
	
	/** 카트에 등록 **/
	@PostMapping("cart")
	public boolean postCart(@ModelAttribute Cart c) {
		return cartService.create(c);
	}
	
	/** 카트 리스트 가져오기 **/
	@GetMapping("cart")
	public List<Product> getCart(@SessionAttribute Customer customer){
		return cartService.getList(customer.getCustomer_id());
	}
	
}
