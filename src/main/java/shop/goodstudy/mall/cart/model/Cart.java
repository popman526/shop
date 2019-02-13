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

	private long cart_id;
	private long product_id;
	private String customer_id;
	private long order_quantity;
	private long product_price;
	private String product_name;
	private long total_price;
	private Date rg_date;
	
	@Builder
	public Cart(long cart_id, long product_id, String customer_id, long order_quantity, long product_price,
			String product_name, long total_price, Date rg_date) {
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
