package shop.goodstudy.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shop.goodstudy.mall.product.DownLoad;

@Configuration
public class WebConfig {

	@Bean
	public DownLoad downloadview() {
		return new DownLoad();
	}
}
