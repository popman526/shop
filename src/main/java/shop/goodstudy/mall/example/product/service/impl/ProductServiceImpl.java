package shop.goodstudy.mall.example.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.goodstudy.mall.example.product.mapper.ProductMapper;
import shop.goodstudy.mall.example.product.model.Product;
import shop.goodstudy.mall.example.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductMapper productMapper;
	
	@Override
	public Product findById(Long id) {
		return productMapper.findById(id);
	}

	@Override
	public List<Product> findAllProduct() {
		return productMapper.findAllProduct();
	}

	@Override
	public int addProduct(Product product) {
		return productMapper.addProduct(product);
	}

	@Override
	public int modifyProduct(Product product) {
		return productMapper.modifyProduct(product);
	}

	@Override
	public int deleteProduct(Product product) {
		return productMapper.deleteProduct(product);
	}

}
