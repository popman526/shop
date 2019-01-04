package shop.goodstudy.mall.product.model;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("product")
public class Product {

	private long product_id;
	private String product_name;
	private long product_state;
	private long product_price;
	private long product_quantity;
	private String reg_id;
	private Timestamp reg_dt;
	private String mod_id;
	private Timestamp mod_dt;
	
	public Product() {
		
	}
	
	public Product(String product_name, long product_state, long product_price, long product_quantity, String reg_id) {
		super();
		this.product_name = product_name;
		this.product_state = product_state;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.reg_id = reg_id;
	}
	
	public Product(long product_id, String product_name, long product_state, long product_price, long product_quantity, String mod_id) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_state = product_state;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.mod_id = mod_id;
	}

}
