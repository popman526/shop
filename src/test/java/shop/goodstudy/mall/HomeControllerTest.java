package shop.goodstudy.mall;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import shop.goodstudy.mall.product.model.Product;
import shop.goodstudy.mall.product.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService mockProductService;

	@Test
	public void homeTest() throws Exception {
		int startRow = 0;
		int endRow = 9;
		List<Product> products = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			products.add(new Product(i, "상품"+i, 0, 1000, 100, "등록자"+i));
		}
		
		when(mockProductService.getProductCount()).thenReturn(12);
		when(mockProductService.selectAllProduct(startRow, endRow)).thenReturn(products);
		
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andDo(print());
	}

}
