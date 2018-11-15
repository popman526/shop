package shop.goodstudy.mall.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.product.model.Product;

@Mapper
public interface ProductMapper {
	Product selectProductByProductId(Long product_id);
	List<Product> selectAllProduct();
	int insertProduct(Product product);
}
