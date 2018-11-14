package shop.goodstudy.mall.controller.product;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import shop.goodstudy.mall.controller.CustomerSessionUtils;
import shop.goodstudy.mall.customer.model.Customer;
import shop.goodstudy.mall.product.model.Image;
import shop.goodstudy.mall.product.model.Product;
import shop.goodstudy.mall.product.service.ProductService;

@Controller
public class ProductCreateController {
	
	@Autowired
    private ProductService productService;

    @PostMapping("/product/create")
    public String productCreateJsp(HttpServletRequest request, MultipartHttpServletRequest mRequest) {
    	if (!CustomerSessionUtils.isLogined(request.getSession())) {
            return "redirect:/customer/loginForm";
        }
    	
    	Customer customer = CustomerSessionUtils.getCustomerFromSession(request.getSession());
    	
        Product product = new Product(request.getParameter("name"), Long.parseLong(request.getParameter("state")), 
        		Long.parseLong(request.getParameter("price")), customer.getCustomer_id());
        productService.addProduct(product);
        
        List<MultipartFile> filelist = mRequest.getFiles("file");
		Iterator<MultipartFile> it = filelist.iterator();
		while (it.hasNext()) {
			MultipartFile mFile = it.next();
			String image_name = mFile.getOriginalFilename();
			String physical_name = image_name + "_" + System.currentTimeMillis();
			byte[] imagefile = null;
			try {
				imagefile = new byte[(int) mFile.getSize()];
				imagefile = mFile.getBytes();
				Image image = new Image();
				image.setImage_name(image_name);
				image.setImagefile(imagefile);
				image.setPhysical_name(physical_name);
				image.setProduct_id(product.getProduct_id());
				productService.insertImage(image);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        
        return "redirect:/";
	}
    
}
