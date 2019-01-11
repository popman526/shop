package shop.goodstudy.mall.image.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.image.model.Image;

@Mapper
public interface ImageMapper {
	List<Image> selectAllImagesByProductId(long product_id); // 상품 상세 조회 시 모든 이미지 조회
	int insertImage(Image image); // 상품 글쓰기(이미지)
	Image downloadMainImage(int product_id); // 메인 이미지 다운로드
	Image downloadContentImage(int image_id); // 상품 상세 이미지 전체 다운로드
	int deleteAllImageByProductId(long product_id); // 상품 이미지 삭제
}