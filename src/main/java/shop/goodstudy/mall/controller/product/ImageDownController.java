package shop.goodstudy.mall.controller.product;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.product.mapper.ProductMapper;
import shop.goodstudy.mall.product.model.Image;

@Controller
public class ImageDownController {
	
	@Autowired
	private ProductMapper productMapper;

	@GetMapping("/product/mainImageDown")
	public ModelAndView mainImageDown(HttpServletRequest request, ModelAndView mav) {
		int product_id=Integer.parseInt((request.getParameter("product_id")));
		Image image= productMapper.mainImageDown(product_id);
		mav.addObject("imagefile", image.getImagefile());
		mav.setViewName("downloadview");
		return mav;
	}
}
