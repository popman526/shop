package shop.goodstudy.mall.image.service;

import java.util.List;

import shop.goodstudy.mall.image.model.Image;
import shop.goodstudy.mall.image.model.Thumbnail;

public interface ImageService {
	int insertImage(Image image);
	Image downloadMainImage(int product_id);
	Thumbnail downloadThumbnail(int product_id);
	List<Image> selectAllImageIdByProductId(long product_id);
	Image downloadContentImage(int image_id);
	int insertThumbnail(Thumbnail thumbnail);
	int countThumbnail(int product_id);
}
