package shop.goodstudy.mall.order.model;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import shop.goodstudy.mall.product.model.Product;

@Data
@Alias("order")
public class OrderVO {
	
	private int order_id;
	private String order_date;
	private int customer_code;
	private int order_total_price;
	private int order_state;
	private int product_id;
	private String product_name;
	private int order_quantity;
	
}
