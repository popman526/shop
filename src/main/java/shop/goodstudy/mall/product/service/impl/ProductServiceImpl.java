package shop.goodstudy.mall.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.goodstudy.mall.product.mapper.ProductMapper;
import shop.goodstudy.mall.product.model.Product;
import shop.goodstudy.mall.product.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;

	@Override
	public Product selectProductByProductId(Long product_id) {
		return productMapper.selectProductByProductId(product_id);
	}

	@Override
	public List<Product> selectAllProduct() {
		return productMapper.selectAllProduct();
	}

	@Override
	public int insertProduct(Product product) {
		return productMapper.insertProduct(product);
	}

	@Override
	public int deleteProductByProductId(Long product_id) {
		return productMapper.deleteProductByProductId(product_id);
	}

	@Override
	public int updateProductByProduct(Product product) {
		return productMapper.updateProductByProduct(product);
	}
	
}
