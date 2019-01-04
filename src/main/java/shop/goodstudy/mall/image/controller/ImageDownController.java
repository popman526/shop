package shop.goodstudy.mall.image.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.image.model.Image;
import shop.goodstudy.mall.image.service.ImageService;

@Controller
public class ImageDownController {
	
	@Autowired
	private ImageService imageService;

	
	/**
	 * 이미지: 메인 이미지 불러오기
	 * @param request
	 * @param mav
	 * @return
	 */
	@GetMapping("/product/downloadMainImage")
	public ModelAndView downloadMainImage(HttpServletRequest request, ModelAndView mav) {
		int product_id=Integer.parseInt((request.getParameter("product_id")));
		Image image= imageService.downloadMainImage(product_id);
		mav.addObject("imagefile", image.getImagefile());
		mav.setViewName("downloadview");
		return mav;
	}
	
	
	/**
	 * 이미지: 상품 상세 이미지 전체 불러오기
	 * @param request
	 * @param mav
	 * @return
	 */
	@GetMapping("/product/downloadContentImage")
	public ModelAndView downloadContentImage(HttpServletRequest request, ModelAndView mav) {
		int image_id=Integer.parseInt((request.getParameter("image_id")));
		Image image= imageService.downloadContentImage(image_id);
		mav.addObject("imagefile", image.getImagefile());
		mav.setViewName("downloadview");
		return mav;
	}
}
