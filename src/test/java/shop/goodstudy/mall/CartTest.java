package shop.goodstudy.mall;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import shop.goodstudy.mall.cart.mapper.CartMapper;
import shop.goodstudy.mall.cart.model.Cart;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTest {

	@Autowired CartMapper cartMapper;
	
	@Test
	public void create() {
		
	}
	
}
