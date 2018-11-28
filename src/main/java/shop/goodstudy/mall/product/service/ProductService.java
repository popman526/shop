package shop.goodstudy.mall.product.service;

import java.util.List;

import shop.goodstudy.mall.product.model.Product;

public interface ProductService {
	Product selectProductByProductId(Long product_id);
	List<Product> selectAllProduct();
	int insertProduct(Product product);
	int deleteProductByProductId(Long product_id);
	int updateProductByProduct(Product product);
}
