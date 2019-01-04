package shop.goodstudy.mall.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.product.model.Product;

@Mapper
public interface ProductMapper {
	List<Product> selectAllProduct(); // 전체 상품 리스트 조회
	Product selectProductByProductId(Long product_id); // 상품 클릭 시 상품 정보 조회
	int insertProduct(Product product); // 상품 글쓰기
	int deleteProductByProductId(Long product_id);
	int updateProductByProduct(Product product);
}
