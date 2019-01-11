package shop.goodstudy.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shop.goodstudy.mall.common.DownLoadImageUtils;

@Configuration
public class WebConfig {

	/**
	 * 이미지 다운로드를 위한 메서드
	 * @return
	 */
	@Bean
	public DownLoadImageUtils downloadview() {
		return new DownLoadImageUtils();
	}
}
