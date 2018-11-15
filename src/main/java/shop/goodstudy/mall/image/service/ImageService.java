package shop.goodstudy.mall.image.service;

import java.util.List;

import shop.goodstudy.mall.image.model.Image;

public interface ImageService {
	int insertImage(Image image);
	Image mainImageDown(int product_id);
	List<Image> findAllImageByProduct_Id(long product_id);
}
