package shop.goodstudy.mall.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductWriteFormController {

	@GetMapping("/product/form")
	public String productWriteFormJsp() {
		return "product/writeForm";
	}
}
