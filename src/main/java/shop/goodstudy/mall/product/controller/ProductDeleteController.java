package shop.goodstudy.mall.product.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import shop.goodstudy.mall.product.service.ProductService;

@Controller
public class ProductDeleteController {
	
	@Autowired
    private ProductService productService;

    @PostMapping("/product/delete")
    public String productDeleteJsp(HttpServletRequest request) {
    	Long product_id = Long.parseLong(request.getParameter("product_id"));
    	productService.deleteProductByProductId(product_id);
    	return "redirect:/";
	}
    
}
