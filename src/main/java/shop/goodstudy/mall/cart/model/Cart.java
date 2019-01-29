package shop.goodstudy.mall.cart.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Alias("cart")
public class Cart {

	private int cart_id;
	private int product_id;
	private String customer_id;
	private int order_quantity;
	private Date rg_date;
	private int order_total_price;
	
	@Builder
	public Cart(int cart_id, int product_id, String customer_id, int order_quantity, Date rg_date,
			int order_total_price) {
		super();
		this.cart_id = cart_id;
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.order_quantity = order_quantity;
		this.rg_date = rg_date;
		this.order_total_price = order_total_price;
	}
	
}
