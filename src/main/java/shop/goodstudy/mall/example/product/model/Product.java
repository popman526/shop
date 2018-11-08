package shop.goodstudy.mall.example.product.model;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Alias("product")
public class Product {
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String status;
	@NonNull
	private Long price;
}
