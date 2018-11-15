package shop.goodstudy.mall.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.goodstudy.mall.product.mapper.ProductMapper;
<<<<<<< HEAD
import shop.goodstudy.mall.product.model.Image;
import shop.goodstudy.mall.product.model.Product;
import shop.goodstudy.mall.product.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;

	@Override
	public Product findById(Long id) {
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

	@Override
	public int insertImage(Image image) {
		return productMapper.insertImage(image);
	}

	@Override
	public Image mainImageDown(int product_id) {
		return productMapper.mainImageDown(product_id);
	}
	
=======
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
>>>>>>> branch 'dev-bogurs' of https://github.com/popman526/shop.git
}
