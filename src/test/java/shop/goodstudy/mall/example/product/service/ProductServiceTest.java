//package shop.goodstudy.mall.example.product.service;
//
//import java.util.List;
//
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import lombok.extern.slf4j.Slf4j;
//import shop.goodstudy.mall.product.model.Product;
//import shop.goodstudy.mall.product.service.ProductService;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@Transactional
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@Slf4j
//public class ProductServiceTest {
//	
////	private static final Logger log = LoggerFactory.getLogger(ProductServiceTest.class);
//	
//	@Autowired
//	ProductService service;
//
//	@Test
//	public void test01_findById() {
//		Product product = service.findById(1L);
//		log.info("product : {}", product);
//	}
//	
//	@Test
//	public void test02_findAllProduct() {
//		List<Product> products = service.findAllProduct();
//		log.info("product : {}", products);
//	}
//
//	@Test
//	public void test03_addProduct() {
//		int a = service.addProduct(new Product("모니터", "03", 350_000L));
//		int b = service.addProduct(new Product("이어폰", "01", 99_000L));
//		List<Product> products = service.findAllProduct();
//		
//		log.info("a : {}", a);
//		log.info("b : {}", b);
//		log.info("product : {}", products);
//	}
//	
//	@Test
//	public void test04_modifyProduct() {
//		int a = service.modifyProduct(new Product(1L, "노트북", "02", 1_200_000L));
//		int b = service.modifyProduct(new Product(2L, "티셔츠", "01", 29_000L));
//		List<Product> products = service.findAllProduct();
//		
//		log.info("a : {}", a);
//		log.info("b : {}", b);
//		log.info("product : {}", products);
//	}
//	
//
//}
