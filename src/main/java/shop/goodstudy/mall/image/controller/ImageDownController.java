package shop.goodstudy.mall.image.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.image.mapper.ImageMapper;
import shop.goodstudy.mall.image.model.Image;

@Controller
public class ImageDownController {
	
	@Autowired
	private ImageMapper imageMapper;

	@GetMapping("/product/downloadMainImage")
	public ModelAndView downloadMainImage(HttpServletRequest request, ModelAndView mav) {
		int product_id=Integer.parseInt((request.getParameter("product_id")));
		Image image= imageMapper.downloadMainImage(product_id);
		mav.addObject("imagefile", image.getImagefile());
		mav.setViewName("downloadview");
		return mav;
	}
	
	@GetMapping("/product/downloadContentImage")
	public ModelAndView downloadContentImage(HttpServletRequest request, ModelAndView mav) {
		int image_id=Integer.parseInt((request.getParameter("image_id")));
		Image image= imageMapper.downloadContentImage(image_id);
		mav.addObject("imagefile", image.getImagefile());
		mav.setViewName("downloadview");
		return mav;
	}
}
