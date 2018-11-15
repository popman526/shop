package shop.goodstudy.mall.image.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.image.model.Image;

@Mapper
public interface ImageMapper {
	int insertImage(Image image);
	Image mainImageDown(int product_id);
	List<Image> findAllImageByProduct_Id(long product_id);
}
