package shop.goodstudy.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.product.mapper.ProductMapper;

@Controller
public class HomeController {
	
	@Autowired
	private ProductMapper productMapper;
	
	@GetMapping("/")
	public ModelAndView helloJsp(ModelAndView mav) {
		mav.addObject("products", productMapper.selectAllProduct());
		mav.setViewName("home");
		return mav;
	}
}
