package shop.goodstudy.mall.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.goodstudy.mall.product.mapper.ProductMapper;
import shop.goodstudy.mall.product.model.Product;

@Service
@Transactional
public class ProductServiceImpl {

	@Autowired
	ProductMapper productMapper;
	
	public Product getProductByPrdNo(Long prd_no) {
		return productMapper.selectProductByPrdNo(prd_no);
	}
	
	public List<Product> getAllProduct() {
		return productMapper.selectAllProduct();
	}
	
	public void addProduct(Product product) {
		productMapper.insertProduct(product);
	}
}
