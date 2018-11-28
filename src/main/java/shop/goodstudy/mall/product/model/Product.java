package shop.goodstudy.mall.product.model;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("product")
public class Product {

	private long product_id;
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
	}
	
	public Product(long product_id, String product_name, Long product_state, Long product_price, String mod_id) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_state = product_state;
		this.product_price = product_price;
		this.mod_id = mod_id;
	}

}
