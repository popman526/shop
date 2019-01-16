package shop.goodstudy.mall.image.service;

import shop.goodstudy.mall.image.model.Image;
import shop.goodstudy.mall.image.model.Thumbnail;

public interface ImageService {
	Image downloadMainImage(int product_id); // 상품 리스트(메인화면)에서 메인 이미지만 가져오기
	Image downloadContentImage(int image_id); // 상품 상세화면에서 전체 이미지 가져오기
	
	Thumbnail downloadThumbnail(int product_id);
	int insertThumbnail(Thumbnail thumbnail);
	int countThumbnail(int product_id);
}
