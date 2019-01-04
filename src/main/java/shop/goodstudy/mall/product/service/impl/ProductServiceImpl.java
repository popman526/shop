package shop.goodstudy.mall.product.service.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.image.mapper.ImageMapper;
import shop.goodstudy.mall.image.model.Image;
import shop.goodstudy.mall.product.mapper.ProductMapper;
import shop.goodstudy.mall.product.model.Product;
import shop.goodstudy.mall.product.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	ImageMapper imageMapper;
	
	/**
	 * 상품: 모든 상품 리스트 조회
	 */
	@Override
	public List<Product> selectAllProduct() {
		return productMapper.selectAllProduct();
	}

	/**
	 * 상품: 특정 상품 상세 조회(상품, 이미지)
	 */
	@Override
	public ModelAndView selectProductByProductId(Long product_id, ModelAndView mav) {
		Product product = productMapper.selectProductByProductId(product_id);
        List<Image> images = imageMapper.selectAllImagesByProductId(product_id);
        
        mav.addObject("product", product);
        mav.addObject("images", images);
		return mav;
	}

	@Override
	public void insertProduct(Product product, List<MultipartFile> filelist) throws IOException {
		productMapper.insertProduct(product);
		
		Iterator<MultipartFile> it = filelist.iterator();
		while (it.hasNext()) {
			MultipartFile mFile = it.next();
			String image_name = mFile.getOriginalFilename();
			String physical_name = image_name + "_" + System.currentTimeMillis();
			byte[] imagefile = null;
			Image image = new Image();
			imagefile = new byte[(int) mFile.getSize()];
			imagefile = mFile.getBytes();
			image.setImage_name(image_name);
			image.setImagefile(imagefile);
			image.setPhysical_name(physical_name);
			image.setProduct_id(product.getProduct_id());
			imageMapper.insertImage(image);
		}
	}
	
	@Override
	public void updateProductByProduct(Product product, List<MultipartFile> filelist) throws IOException {
		if (filelist != null) {
			imageMapper.deleteAllImageByProductId(product.getProduct_id());
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
				imageMapper.insertImage(image);
			}
		}
    	
		productMapper.updateProductByProduct(product);
	}

	@Override
	public void deleteProductByProductId(Long product_id) {
		productMapper.deleteProductByProductId(product_id);
		imageMapper.deleteAllImageByProductId(product_id);
	}
	
}
