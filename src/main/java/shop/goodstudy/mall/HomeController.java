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
	public ModelAndView home(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		PagingUtils pagingUtils = new PagingUtils(); // 메인 화면 페이징을 위한 유틸 불러오기
		String pageCode; // 페이징 처리 결과(StringBuilder 저장)
		int count = 0;
		List<Product> products;
		
		String pageNum = req.getParameter("pageNum"); // 페이지 번호 (기본 1)
		if (pageNum == null) {
			pageNum = "1";
		}
		
		count = productService.getProductCount();
		
		int pageSize = 10; //TODO: 외부 설정으로 빼기. 한 페이지의 글의 갯수
		int pageBlock = 10; //TODO: 외부 설정으로 빼기. 한 블럭에 보여줄 페이지 갯수
		
		pagingUtils.paging(Integer.parseInt(pageNum), count, pageSize, pageBlock);
		pageCode = pagingUtils.getSb().toString();
		
		System.out.println(pagingUtils.getStartRow());
		if (count > 0) { 
			products = productService.selectAllProduct(pagingUtils.getStartRow(), pagingUtils.getEndRow()); // 현재 페이지에 해당하는 글 목록 가져오기
		} else {
			products = null;
		}
		
		mav.addObject("count", count);
		mav.addObject("pageNum", pageNum);
		mav.addObject("pageCode", pageCode);
		mav.addObject("products", products);
		mav.setViewName("home");
		return mav;
	}
}
