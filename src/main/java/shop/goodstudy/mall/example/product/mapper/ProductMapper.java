package shop.goodstudy.mall.example.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.example.product.model.Product;

@Mapper
public interface ProductMapper {
	Product findById(Long id);
	List<Product> findAllProduct();
	int addProduct(Product product);
	int modifyProduct(Product product);
}
