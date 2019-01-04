package shop.goodstudy.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shop.goodstudy.mall.util.DownLoadImageUtils;

@Configuration
public class WebConfig {

	@Bean
	public DownLoadImageUtils downloadview() {
		return new DownLoadImageUtils();
	}
}
