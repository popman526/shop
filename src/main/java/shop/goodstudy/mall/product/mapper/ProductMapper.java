package shop.goodstudy.mall.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.product.model.Product;

@Mapper
public interface ProductMapper {
	List<Product> selectAllProduct(int startRow, int endRow); // 전체 상품 리스트 조회
	Product selectProductByProductId(Long product_id); // 상품 클릭 시 상품 정보 조회
	int insertProduct(Product product); // 상품 글쓰기
	int deleteProductByProductId(Long product_id); // 상품 삭제
	int updateProductByProduct(Product product); // 상품 업데이트
	int getProductCount(); // 상품 전체 개수 가져오기(페이징 처리 위함)
	List<Product> getCartList(String id); // 장바구니에 담긴 상품 목록
}
