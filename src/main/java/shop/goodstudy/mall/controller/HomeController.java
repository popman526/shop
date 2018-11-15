package shop.goodstudy.mall.controller;

<<<<<<< HEAD
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
=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String helloJsp() {
		return "home";
>>>>>>> branch 'dev-bogurs' of https://github.com/popman526/shop.git
	}
}
