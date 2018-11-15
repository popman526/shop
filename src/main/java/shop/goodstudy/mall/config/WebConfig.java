package shop.goodstudy.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

<<<<<<< HEAD
import shop.goodstudy.mall.image.DownLoad;
=======
import shop.goodstudy.mall.product.DownLoad;
>>>>>>> branch 'dev-bogurs' of https://github.com/popman526/shop.git

@Configuration
public class WebConfig {

	@Bean
	public DownLoad downloadview() {
		return new DownLoad();
	}
}
