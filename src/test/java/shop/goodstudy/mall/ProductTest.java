package shop.goodstudy.mall;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import shop.goodstudy.mall.product.mapper.ProductMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

	@Autowired private ProductMapper productMapper;
	
	@Test
	public void getCartListTest() {
		
		assertThat(productMapper.getCartList("spring03").get(0).getProduct_id(),is(23L));
		
	}
	
}
