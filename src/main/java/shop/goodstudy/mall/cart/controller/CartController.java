package shop.goodstudy.mall.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import shop.goodstudy.mall.cart.service.CartService;
import shop.goodstudy.mall.customer.model.Customer;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired private CartService cartService;
	
	@GetMapping("")
	public String getCart(Model model, @SessionAttribute("customer") Customer customer) {
		
		model.addAttribute("cart", cartService.getList(customer.getCustomer_id()));
		return "/cart/cartList";
		
	}
	
	@DeleteMapping("")
	public String deleteCart(@SessionAttribute("customer") Customer customer
			, @RequestParam("product_id") List<Long> products) {
		cartService.delete(products, customer.getCustomer_id());
		return "redirect:/cart";
	}
	
}
