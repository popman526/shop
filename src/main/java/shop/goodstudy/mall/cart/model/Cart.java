package shop.goodstudy.mall.cart.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Alias("cart")
public class Cart {

	private int cart_id;
	private int product_id;
	private String customer_id;
	private int order_quantity;
	private int product_price;
	private String product_name;
	private int total_price;
	private Date rg_date;
	
	@Builder
	public Cart(int cart_id, int product_id, String customer_id, int order_quantity, int product_price,
			String product_name, int total_price, Date rg_date) {
		super();
		this.cart_id = cart_id;
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.order_quantity = order_quantity;
		this.product_price = product_price;
		this.product_name = product_name;
		this.total_price = total_price;
		this.rg_date = rg_date;
	}
	
}
