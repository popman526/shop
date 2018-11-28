package shop.goodstudy.mall.image.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.image.model.Image;

@Mapper
public interface ImageMapper {
	int insertImage(Image image);
	Image downloadMainImage(int product_id);
	List<Image> selectAllImageIdByProductId(long product_id);
	Image downloadContentImage(int image_id);
	int deleteAllImageByProductId(long product_id);
}