package shop.goodstudy.mall.example.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/admin/home")
	public String adminHome() {
		return "example/admin/adminhome";
	}
}
