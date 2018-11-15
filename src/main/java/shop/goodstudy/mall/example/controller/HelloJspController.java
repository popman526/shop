package shop.goodstudy.mall.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloJspController {
	
	@GetMapping("/home")
	public String home() {
		return "example/home";
	}
	
	@GetMapping("/hello")
	public String helloJsp() {
		return "example/hello";
	}
}
