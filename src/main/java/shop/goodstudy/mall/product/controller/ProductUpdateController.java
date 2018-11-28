package shop.goodstudy.mall.product.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import shop.goodstudy.mall.image.model.Image;
import shop.goodstudy.mall.image.service.ImageService;
import shop.goodstudy.mall.product.model.Product;
import shop.goodstudy.mall.product.service.ProductService;
import shop.goodstudy.mall.util.CustomerSessionUtils;
import shop.goodstudy.mall.util.FileUtils;

@Controller
public class ProductUpdateController {
	
	@Autowired
    private ProductService productService;
	
	@Autowired
	private ImageService imageService;

    @PostMapping("/product/update")
    public String productCreateJsp(HttpServletRequest request, MultipartHttpServletRequest mRequest) throws IOException {
    	if (!CustomerSessionUtils.isLogined(request.getSession())) {
            return "redirect:/customer/loginForm";
        }
    	
        Product product = new Product(Long.parseLong(request.getParameter("product_id")), request.getParameter("name"), Long.parseLong(request.getParameter("state")), 
        		Long.parseLong(request.getParameter("price")), CustomerSessionUtils.getCustomerFromSession(request.getSession()).getCustomer_id());
        
        String isDeleteLegacyFiles = request.getParameter("deletelegacy");
        if (isDeleteLegacyFiles.equals(FileUtils.DELETE_LEGACY_FILES)) {
        	imageService.deleteAllImageByProductId(product.getProduct_id());
        	List<MultipartFile> filelist = mRequest.getFiles("file");
        	Iterator<MultipartFile> it = filelist.iterator();
        	while (it.hasNext()) {
        		MultipartFile mFile = it.next();
        		String image_name = mFile.getOriginalFilename();
        		String physical_name = image_name + "_" + System.currentTimeMillis();
        		byte[] imagefile = null;
        		imagefile = new byte[(int) mFile.getSize()];
        		imagefile = mFile.getBytes();
        		Image image = new Image();
        		image.setImage_name(image_name);
        		image.setImagefile(imagefile);
        		image.setPhysical_name(physical_name);
        		image.setProduct_id(product.getProduct_id());
        		imageService.insertImage(image);
        	}
        }
        productService.updateProductByProduct(product);
        
        return "redirect:/";
	}
    
}