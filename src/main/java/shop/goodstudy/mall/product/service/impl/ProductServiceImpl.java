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
	public Product findProductById(Long product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectAllProduct() {
		return productMapper.selectAllProduct();
	}

	@Override
	public int addProduct(Product product) {
		return productMapper.addProduct(product);
	}

	@Override
	public int modifyProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
