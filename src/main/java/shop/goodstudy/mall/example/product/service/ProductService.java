package shop.goodstudy.mall.example.product.service;

import java.util.List;

import shop.goodstudy.mall.example.product.model.Product;

public interface ProductService {
	Product findById(Long id);
	List<Product> findAllProduct();
	int addProduct(Product product);
	int modifyProduct(Product product);
}
