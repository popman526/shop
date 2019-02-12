package shop.goodstudy.mall.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

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
	
	/**
	 * REST DELETE, PUT을 사용하기 위한 필터 설정
	 * @return
	 */
	@Bean
	public FilterRegistrationBean httpMethodFilter() {
		FilterRegistrationBean filterBean = new FilterRegistrationBean();
		filterBean.setFilter(new HiddenHttpMethodFilter());
		filterBean.addUrlPatterns("/*");
		return filterBean;
	}
	
}
