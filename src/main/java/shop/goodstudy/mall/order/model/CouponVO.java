package shop.goodstudy.mall.order.model;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("coupon")
public class CouponVO {
	
	private String coupon_name;
	private String customer_id;
	private int discount;
	private String discount_type;
	private int valid_date;
	private String status;
	
}
