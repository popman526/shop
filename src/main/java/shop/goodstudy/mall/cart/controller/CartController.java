package shop.goodstudy.mall.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import shop.goodstudy.mall.cart.service.CartService;
import shop.goodstudy.mall.customer.model.Customer;

@Controller
public class CartController {

	@Autowired private CartService cartService;
	
	@GetMapping("cart")
	public String getCart(Model model, @SessionAttribute("customer") Customer customer) {
		
		model.addAttribute("cart", cartService.getList(customer.getCustomer_id()));
		return "/cart/cartList";
		
	}
	
}
