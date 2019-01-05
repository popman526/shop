package shop.goodstudy.mall.order.model;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import shop.goodstudy.mall.product.model.Product;

@Data
@Alias("order_detail")
public class OrderDetailVO {
	
	private int order_detail_id;
	private int order_id;
	private int product_id;
	private String product_name;
	private int product_price;
	private int order_quantity;
	
}
