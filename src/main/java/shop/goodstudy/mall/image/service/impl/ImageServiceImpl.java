package shop.goodstudy.mall.image.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.goodstudy.mall.image.mapper.ImageMapper;
import shop.goodstudy.mall.image.model.Image;
import shop.goodstudy.mall.image.service.ImageService;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ImageMapper imageMapper;

	@Override
	public int insertImage(Image image) {
		return imageMapper.insertImage(image);
	}

	@Override
	public Image downloadMainImage(int product_id) {
		return imageMapper.downloadMainImage(product_id);
	}

	@Override
	public List<Image> selectAllImageIdByProductId(long product_id) {
		return imageMapper.selectAllImageIdByProductId(product_id);
	}

	@Override
	public Image downloadContentImage(int image_id) {
		return imageMapper.downloadContentImage(image_id);
	}
	
}
