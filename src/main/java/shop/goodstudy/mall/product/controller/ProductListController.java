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
    
}
