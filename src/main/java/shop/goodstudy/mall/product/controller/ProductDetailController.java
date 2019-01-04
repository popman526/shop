package shop.goodstudy.mall.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.product.model.Product;
import shop.goodstudy.mall.product.service.ProductService;
import shop.goodstudy.mall.util.CustomerSessionUtils;
import shop.goodstudy.mall.util.DownLoadImageUtils;

@Controller
public class ProductDetailController {
	
	@Autowired
    private ProductService productService;

	
	/**
	 * 상품: 상품 상세화면 불러오기
	 * @param request
	 * @return
	 */
    @GetMapping("/product/show")
    public ModelAndView productShow(HttpServletRequest request) {
    	long product_id = Long.parseLong(request.getParameter("product_id"));

    	ModelAndView mav = new ModelAndView();
    	mav = productService.selectProductByProductId(product_id, mav);
        mav.setViewName("/product/show");
        return mav;
	}
    
    
	/**
	 * 상품: 업데이트 폼으로 넘기기(JSP)
	 * @param request
	 * @return
	 */
    @GetMapping("/product/updateForm")
    public ModelAndView productUpdateForm(HttpServletRequest request) {
    	Long product_id = Long.parseLong(request.getParameter("product_id"));
    	
    	ModelAndView mav = new ModelAndView();
    	mav = productService.selectProductByProductId(product_id, mav);
    	mav.setViewName("/product/updateForm");
        return mav;
	}
    

    /**
     * 상품: 업데이트(DB)
     * @param request
     * @param mRequest
     * @return
     * @throws IOException
     */
    @PostMapping("/product/update")
    public String productUpdate(HttpServletRequest request, MultipartHttpServletRequest mRequest) throws IOException {
    	if (!CustomerSessionUtils.isLogined(request.getSession())) {
            return "redirect:/customer/loginForm";
        }
    	
        Product product = new Product(Long.parseLong(request.getParameter("product_id")), request.getParameter("name"), Long.parseLong(request.getParameter("state")), 
        		Long.parseLong(request.getParameter("price")), Long.parseLong(request.getParameter("quantity")), CustomerSessionUtils.getCustomerFromSession(request.getSession()).getCustomer_id());
        
        String isDeleteLegacyFiles = request.getParameter("deletelegacy");
        if (isDeleteLegacyFiles.equals(DownLoadImageUtils.DELETE_LEGACY_FILES)) {
        	List<MultipartFile> filelist = mRequest.getFiles("file");
        	productService.updateProductByProduct(product, filelist);
        } else {
        	productService.updateProductByProduct(product, null);
        }
        
        return "redirect:/";
	}
    
    
    /**
     * 상품: 삭제(DB)
     * @param request
     * @return
     */
    @PostMapping("/product/delete")
    public String productDelete(HttpServletRequest request) {
    	Long product_id = Long.parseLong(request.getParameter("product_id"));
    	productService.deleteProductByProductId(product_id);
    	return "redirect:/";
	}
    
    
    /**
     * 상품: 구입
     * @param product
     * @param request
     * @return
     */
    @PostMapping("/product/buy")
    public ModelAndView productBuyJsp(@ModelAttribute Product product, HttpServletRequest request) {
    	long buyCount = Long.parseLong(request.getParameter("buyCount"));
    	
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/product/buyForm");
        mav.addObject("product", product);
        mav.addObject("buyCount", buyCount);
        return mav;
	}
}
