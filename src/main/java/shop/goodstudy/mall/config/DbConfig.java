package shop.goodstudy.mall.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"shop.goodstudy.mall"}, markerInterface = Mapper.class)
public class DbConfig {
	
}
