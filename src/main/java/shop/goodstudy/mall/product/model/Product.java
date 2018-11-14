package shop.goodstudy.mall.product.model;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Alias("product")
public class Product {

	private String product_name;
	private MultipartFile product_img;
	private Long product_state;
	private Long product_price;
	
	public Product(String product_name, MultipartFile product_img, Long product_state, Long product_price) {
		super();
		this.product_name = product_name;
		this.product_img = product_img;
		this.product_state = product_state;
		this.product_price = product_price;
	}

	public Product() {

	}

}
