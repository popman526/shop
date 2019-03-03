package shop.goodstudy.mall.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.common.CustomerSessionUtils;
import shop.goodstudy.mall.common.PagingUtils;
import shop.goodstudy.mall.customer.model.Customer;
import shop.goodstudy.mall.product.model.Product;
import shop.goodstudy.mall.product.service.ProductService;

@Controller
public class ProductListController {
	
	@Autowired
    private ProductService productService;
	
    
    /**
     * 상품: 글쓰기 폼으로 넘기기(JSP)
     * @return
     */
    @GetMapping("/product/form")
	public String productWriteFormJsp() {
		return "product/writeForm";
	}
    
    
    /**
     * 상품: 글쓰기(DB)
     * @param request
     * @param mRequest
     * @return
     * @throws IOException
     */
    @PostMapping("/product/create")
    public String productCreate(HttpServletRequest request, MultipartHttpServletRequest mRequest) throws IOException {
    	if (!CustomerSessionUtils.isLogined(request.getSession())) {
            return "redirect:/customer/loginForm";
        }
    	
    	Customer customer = CustomerSessionUtils.getCustomerFromSession(request.getSession());
    	
        Product product = new Product(request.getParameter("name"), Long.parseLong(request.getParameter("state")), 
        		Long.parseLong(request.getParameter("price")), Long.parseLong(request.getParameter("quantity")), customer.getCustomer_id());
        List<MultipartFile> filelist = mRequest.getFiles("file");

        productService.insertProduct(product, filelist);
        
        return "redirect:/";
	}
    
    
    /**
     * 상품 검색(MySQL의 FULLTEXT 검색 방법을 이용함[boolean 검색]
     * 
     * 검색 예1) 모카골드 -> 모카골드*
     * 검색 예2) 모카골드 연아 -> 모카골드* 연아*
     * 검색 예3) "맥심 모카골드" -> "맥심 모카골드"*
     * 검색 예4) "맥심 모카골드" -커피믹스 -> "맥심 모카골드"* -커피믹스
     * @param request
     * @return
     */
    @PostMapping("/product/getSearchResult")
    public ModelAndView getSearchResult(HttpServletRequest request) {
    	String srchTerm = request.getParameter("srch-term");
    	StringBuilder matchSrchTerm = new StringBuilder();
    	String asterisk = "*";
    	String doubleQuote = "\"";
    	
    	if (srchTerm.indexOf(doubleQuote) != -1) { // 검색어에 쌍따옴표가 있는 경우(문장 검색 모드)
    		int lastIndexDQ = srchTerm.lastIndexOf(doubleQuote);
    		if (lastIndexDQ == srchTerm.length()-1) { // 검색어에 예외 단어가 없는 경우
    			matchSrchTerm.append(srchTerm).append(asterisk);
    		} else {
    			matchSrchTerm.append(srchTerm.substring(0, lastIndexDQ+1)).append(asterisk).append(srchTerm.substring(lastIndexDQ+1));
    		}
    	} else { // 검색어에 쌍따옴표가 없는 경우(단어 검색 모드)
    		String[] srchTerms = srchTerm.split(" ");
    		for (String srchWord : srchTerms) {
    			matchSrchTerm.append(srchWord).append(asterisk);
    		}
    	}
    	
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
		ModelAndView mav = pagingUtils.getPagingMav(request.getParameter("pageNum"), matchSrchTerm.toString());
		mav.setViewName("home");
    	return mav;
    }
}
