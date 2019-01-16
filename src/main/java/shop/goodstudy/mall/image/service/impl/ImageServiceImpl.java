package shop.goodstudy.mall.image.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.goodstudy.mall.image.mapper.ImageMapper;
import shop.goodstudy.mall.image.model.Image;
import shop.goodstudy.mall.image.service.ImageService;

import net.coobird.thumbnailator.Thumbnails;
import shop.goodstudy.mall.image.model.Thumbnail;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ImageMapper imageMapper;

	/**
	 * 이미지: 메인 이미지 다운로드
	 */
	@Override
	public Image downloadMainImage(int product_id) {
		return imageMapper.downloadMainImage(product_id);
	}

	
	/**
	 * 이미지: 상품 상세 이미지 다운로드
	 */
	@Override
	public Image downloadContentImage(int image_id) {
		return imageMapper.downloadContentImage(image_id);
	}
	
	@Override
	public int insertThumbnail(Thumbnail thumbnail) {
		
		return imageMapper.insertThumbnail(thumbnail);
	}
	
	@Override
	public Thumbnail downloadThumbnail(int product_id) {
		return imageMapper.downloadThumbnail(product_id);
	}
	
	@Override
	public int countThumbnail(int product_id) {
		return imageMapper.countThumbnail(product_id);
	}
	
}
