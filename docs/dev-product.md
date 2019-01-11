
# 쇼핑몰 상품 구현
## 로그인 후 상품 등록 및 상품 상세 글 확인하기
* 홈 화면 MVC 구현
* 로그인 MVC 구현
* 상품 MVC 구현
* 상품이미지 업로드 MVC 구현
  
  
## 1.	홈 화면 MVC 구현
* 홈 화면: 상품 리스트를 DB에서 모두 읽어온 후 home.jsp 뷰에 전달한다.  
shop.goodstudy.mall 패키지 내 아래와 같이 구성  
	- controller: HomeController (모든 Product 개체 DB에서 전달 받아 home.jsp에 전달)  
	- product.mapper: ProductMapper (HomeController로 부터 selectAllProduct() 호출 명령 받아서 Service 클래스의 메소드 호출)  
	- product.model: Product (상품 VO)  
	- product.service: ProductService (인터페이스)  
	- product.service.impl: ProductServiceImpl (selectAllProduct() 쿼리 수행 및 결과 전달)  
  
  
## 2.	로그인 MVC 구현
* customer 패키지 내 5개 하위 패키지 아래와 같이 구성  
	- controller: LoginController (입력한 id, pw에 맞는 사용자를 DB에서 찾고 일치하면 로그인), LoginFormController (customer/login.jsp 뷰로 이동)  
	- mapper: CustomerMapper (LoginController로 부터 selectCustomerByCustomerId 호출 명령 받아서 Service 클래스의 메소드 호출)  
	- model: Customer (고객 VO)  
	- service: CustomerService (인터페이스)  
	- service.impl: CustomerServiceImpl (selectCustomerByCustomerId 쿼리 수행 및 결과 전달)  
  
  
## 3.	상품 MVC 구현
* product 패키지 내 5개 하위 패키지 아래와 같이 구성  
	- controller: ProductDetailController (상품 상세 컨트롤러), ProductListController (상품 메인 컨트롤러)  
	- mapper: ProductMapper (상품 생성과 관련한 매퍼 구현)  
	- model: Product (상품 VO)  
	- service: ProductService (인터페이스)  
	- service.impl: ProductServiceImpl (상품 관련 쿼리 수행 및 결과 전달)  
  
  
## 4.	상품이미지 업로드 MVC 구현
* image 패키지 내 5개 하위 패키지 아래와 같이 구성  
	- controller: ImageDownController (상품 이미지 다운로드 컨트롤러. viewname으로 downloadview를 입력하면 DownLoadImage 클래스의 메소드 호출하여 이미지 다운로드 수행. viewname을 입력 후 return하게 되면 downloadview.jsp를 찾게 되는데 WebConfig를 통해 @Bean을 등록하여 호출하게 함)  
	- mapper: ImageMapper (상품 생성과 관련한 매퍼 구현)  
	- model: Image (상품 VO)  
	- service: ImageService (인터페이스)  
	- service.impl: ImageServiceImpl (상품 관련 쿼리 수행 및 결과 전달)  
	- (shop.goodstudy.mall.util): DownLoadImageUtils (AbstractView를 이용해 이미지 다운로드 구현)  
  
* WebConfig.java  

```package shop.goodstudy.mall.config;

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
  
  
