package shop.goodstudy.mall.product.service;

import java.util.List;

import shop.goodstudy.mall.product.model.Image;
import shop.goodstudy.mall.product.model.Product;

public interface ProductService {
	Product findById(Long id);
	List<Product> selectAllProduct();
	int addProduct(Product product);
	int modifyProduct(Product product);
	int insertImage(Image image);
	Image mainImageDown(int product_id);
}
