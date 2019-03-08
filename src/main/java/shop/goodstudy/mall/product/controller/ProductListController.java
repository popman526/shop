package shop.goodstudy.mall.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.common.CustomerSessionUtils;
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
    	String pageNum = request.getParameter("pageNum");
    	ModelAndView mav = productService.getSearchResult(srchTerm, pageNum);
    	return mav;
    }
    
    /**
     * 상품 검색 자동완성 기능(ajax)
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @GetMapping("/product/search/auto")
	public void productSearchAutocomplete(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String srchTerm = request.getParameter("srchTerm");
		String json = productService.getProductsBySrchTerm(srchTerm);
		response.getWriter().write(json);
	}
}
