package shop.goodstudy.mall.product.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import shop.goodstudy.mall.common.PagingUtils;
import shop.goodstudy.mall.image.mapper.ImageMapper;
import shop.goodstudy.mall.image.model.Image;
import shop.goodstudy.mall.product.mapper.ProductMapper;
import shop.goodstudy.mall.product.model.Product;
import shop.goodstudy.mall.product.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	ImageMapper imageMapper;
	
	/**
	 * 상품: 모든 상품 리스트 조회
	 */
	@Override
	public List<Product> selectAllProduct(int startRow, String srchTerm) {
		return productMapper.selectAllProduct(startRow, srchTerm);
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

	
	/**
	 * 상품: 새 상품 등록 (상품, 이미지)
	 */
	@Override
	public void insertProduct(Product product, List<MultipartFile> filelist) throws IOException {
		productMapper.insertProduct(product);
		
		Iterator<MultipartFile> it = filelist.iterator();
		while (it.hasNext()) {
			MultipartFile mFile = it.next();
			String image_name = mFile.getOriginalFilename();
			String physical_name = image_name + "_" + System.currentTimeMillis();
			Image image = new Image();
			byte[] imagefile = mFile.getBytes();
			image.setImage_name(image_name);
			image.setImagefile(imagefile);
			image.setPhysical_name(physical_name);
			image.setProduct_id(product.getProduct_id());
			imageMapper.insertImage(image);
		}
	}
	
	
	/**
	 * 상품: 상품 및 이미지 업데이트
	 * (이미지는 새 상품 이미지가 업로드 된 경우에만 새로 입력됨)
	 */
	@Override
	public void updateProductByProduct(Product product, List<MultipartFile> filelist) throws IOException {
		if (filelist != null) {
			imageMapper.deleteAllImageByProductId(product.getProduct_id());
			Iterator<MultipartFile> it = filelist.iterator();
			while (it.hasNext()) {
				MultipartFile mFile = it.next();
				String image_name = mFile.getOriginalFilename();
				String physical_name = image_name + "_" + System.currentTimeMillis();
				byte[] imagefile = mFile.getBytes();
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

	
	/**
	 * 상품: 상품 및 이미지 삭제
	 */
	@Override
	public void deleteProductByProductId(Long product_id) {
		productMapper.deleteProductByProductId(product_id);
		imageMapper.deleteAllImageByProductId(product_id);
	}

	/**
	 * 상품: 전체 상품 등록 개수 불러오기(페이징 처리 위함)
	 */
	@Override
	public int getProductCount(String srchTerm) {
		return productMapper.getProductCount(srchTerm);
	}
	
	/**
	 * 상품: Home 화면 Image Slider용
	 */
	@Override
	public List<Product> selectHomeSlider() {
		return productMapper.selectHomeSlider();
	}
	
	@Override
	public ModelAndView getSearchResult(String srchTerm, String pageNum) {
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
				return productMapper.selectAllProduct(startRow, srchTerm);
			}
			
			@Override
			public int getProductCount(String srchTerm) {
				return productMapper.getProductCount(srchTerm);
			}
		};
		ModelAndView mav = pagingUtils.getPagingMav(pageNum, matchSrchTerm.toString());
		mav.setViewName("home");
		return mav;
	}

	/**
	 * 상품: 상품 검색 자동완성용
	 * @throws UnsupportedEncodingException 
	 */
	@Override
	public String getProductsBySrchTerm(String srchTerm) throws UnsupportedEncodingException {
		List<Product> products = productMapper.getProductsBySrchTerm(srchTerm);
		
		for (Product product : products) {
			// 한글깨짐 방지를 위해 인코딩하기
		    product.setProduct_name(URLEncoder.encode(product.getProduct_name() , "UTF-8"));
		}
		
		String json = new Gson().toJson(products); // List to JsonArrayString
		logger.debug(json);
		return json;
	}
	
}
