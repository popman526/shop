package shop.goodstudy.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shop.goodstudy.mall.image.DownLoadImage;

@Configuration
public class WebConfig {

	@Bean
	public DownLoadImage downloadview() {
		return new DownLoadImage();
	}
}
