package shop.goodstudy.mall;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.common.PagingUtils;
import shop.goodstudy.mall.product.model.Product;
import shop.goodstudy.mall.product.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	/**
	 * 메인: 메인화면에 전체 상품 목록 불러오기
	 * @param mav
	 * @return
	 */
	@GetMapping("/")
	public ModelAndView home(HttpServletRequest request) {
		PagingUtils pagingUtils = new PagingUtils() {
			
			@Override
			public List<Product> selectAllProduct(int startRow, String srchTerm) {
				return productService.selectAllProduct(startRow, srchTerm);
			}
			
			@Override
			public int getProductCount(String srchTerm) {
				return productService.getProductCount(srchTerm);
			}
		};
		ModelAndView mav = pagingUtils.getPagingMav(request.getParameter("pageNum"), null);
		mav.setViewName("home");
		return mav;
	}
	
}
