package shop.goodstudy.mall.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/example")
	public String hello() {
		return "Hello World!";
	}
}
