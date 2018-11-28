package shop.goodstudy.mall.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.image.model.Image;
import shop.goodstudy.mall.image.service.ImageService;
import shop.goodstudy.mall.product.model.Product;
import shop.goodstudy.mall.product.service.ProductService;

@Controller
public class ProductUpdateFormController {
	
	@Autowired
    private ProductService productService;
	
	@Autowired
	private ImageService imageService;
	
    @GetMapping("/product/updateForm")
    public ModelAndView productCreateJsp(HttpServletRequest request) {
    	Long product_id = Long.parseLong(request.getParameter("product_id"));
    	Product product = productService.selectProductByProductId(product_id);
    	List<Image> images = imageService.selectAllImageIdByProductId(product_id);

    	ModelAndView mav = new ModelAndView();
        mav.setViewName("/product/updateForm");
        mav.addObject("product", product);
        mav.addObject("images", images);
        return mav;
	}
    
}
