package shop.goodstudy.mall.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.product.model.Image;
import shop.goodstudy.mall.product.model.Product;

@Mapper
public interface ProductMapper {
	Product selectProductByPrdNo(Long prd_no);
	List<Product> selectAllProduct();
	int addProduct(Product product);
	int insertImage(Image image);
	Image mainImageDown(int product_id);
}
