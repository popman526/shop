package shop.goodstudy.mall.product.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.product.model.Product;

@Controller
public class ProductBuyController {
	
    @PostMapping("/product/buy")
    public ModelAndView productBuyJsp(@ModelAttribute Product product, HttpServletRequest request) {
//    	int product_id = Integer.parseInt(request.getParameter("product_id"));
//    	String product_name = request.getParameter("product_name");
    	long buyCount = Long.parseLong(request.getParameter("buyCount"));
//    	long product_price = Long.parseLong(request.getParameter("product_price"));
    	
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/product/buyForm");
        mav.addObject("product", product);
        mav.addObject("buyCount", buyCount);
        return mav;
	}
    
}
