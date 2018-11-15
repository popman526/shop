package shop.goodstudy.mall.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginFormController {
	
	@GetMapping("/customer/loginForm")
	public String loginFormJsp() {
		return "customer/login";
	}
}
