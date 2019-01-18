package shop.goodstudy.mall.image.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Thumbnail")
public class Thumbnail {
	private int thumb_id;
	private byte[] thumbfile;
	private int product_id;
}
