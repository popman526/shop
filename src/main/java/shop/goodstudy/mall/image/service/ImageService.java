package shop.goodstudy.mall.image.service;

import java.util.List;

import shop.goodstudy.mall.image.model.Image;

public interface ImageService {
	int insertImage(Image image);
	Image downloadMainImage(int product_id);
	List<Image> selectAllImageIdByProductId(long product_id);
	Image downloadContentImage(int image_id);
	int deleteAllImageByProductId(long product_id);
}
