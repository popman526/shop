package shop.goodstudy.mall.product.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("image")
public class Image {
	private int image_id;
	private String physical_name;
	private String image_name;
	private byte[] imagefile;
	private int product_id;
}
