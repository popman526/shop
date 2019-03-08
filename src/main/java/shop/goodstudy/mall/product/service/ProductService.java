package shop.goodstudy.mall.product.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.product.model.Product;

public interface ProductService {
	List<Product> selectAllProduct(int startRow, String srchTerm); // 모든 상품 리스트 조회
	ModelAndView selectProductByProductId(Long product_id, ModelAndView mav); // 상품 클릭 시 상품 정보 조회
	void insertProduct(Product product, List<MultipartFile> filelist) throws IOException; // 상품 글쓰기(상품, 이미지)
	void updateProductByProduct(Product product, List<MultipartFile> filelist) throws IOException; // 상품 수정하기(상품, 이미지)
	void deleteProductByProductId(Long product_id); // 상품 삭제하기(상품, 이미지)
	int getProductCount(String srchTerm); // 전체 상품 갯수 가져오기(페이징 처리 위함)
	List<Product> selectHomeSlider(); //Home 화면 Image Slider용
	String getProductsBySrchTerm(String srchTerm) throws UnsupportedEncodingException; // 상품 검색 자동완성을 위함
	ModelAndView getSearchResult(String srchTerm, String pageNum); // 상품 검색 기능
}
