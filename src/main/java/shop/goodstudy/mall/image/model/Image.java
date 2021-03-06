package shop.goodstudy.mall.image.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("image")
public class Image {
	private long image_id;
	private String physical_name;
	private String image_name;
	private byte[] imagefile;
	private long product_id;
}
