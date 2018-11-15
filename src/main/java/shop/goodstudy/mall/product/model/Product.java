package shop.goodstudy.mall.product.model;

<<<<<<< HEAD
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("product")
public class Product {

	private int product_id;
	private String product_name;
	private Long product_state;
	private Long product_price;
	private String reg_id;
	private Timestamp reg_dt;
	private String mod_id;
	private Timestamp mod_dt;
	
	public Product() {
		
	}
	
	public Product(String product_name, Long product_state, Long product_price, String reg_id) {
		super();
		this.product_name = product_name;
		this.product_state = product_state;
		this.product_price = product_price;
		this.reg_id = reg_id;
=======
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

>>>>>>> branch 'dev-bogurs' of https://github.com/popman526/shop.git
	}

}
