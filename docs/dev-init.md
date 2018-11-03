
# 개발 환경 세팅
## Hello world! 출력해보기
* 이클립스를 활용한 개발 환경 구축
* 스프링 부트 설정

## 1.	JDK 설치
https://www.oracle.com/technetwork/java/javase/downloads/index.html
우리는 JDK 11 다운로드
JDK 설치 후 환경 변수 path 설정


## 2.	이클립스 설치 
https://www.eclipse.org/downloads/packages/
Eclipse IDE for Java EE Developers 의 64-bit 다운로드
JDK 11 호환을 위한 플러그인 설치
Help - Eclipse Marketplace
java 11로 검색
Java 11 Support for Eclipse 설치


## 3.	이클립스 기본 설정
Window - Preference 검색 텍스트 박스 'enco' 로 검색
아래 모든 설정을 UTF-8로 설정
Content Types, Workspace, Css Files, HTML Files, JSP Files


## 4.	STS 플러그인 설정 
Help - Eclipse Marketplace
sts 로 검색
Spring Tools 4 설치


## 5.	spring boot 시작

### 1)	이클립스로 시작
New - Spring Starter Project
 
JAVA version : 11
Type : Maven
Packaging : Jar
Group : shop.goodstudy
Artifact : shoppingmall
Package : shop.goodstudy.shoppingmall

Spring boot version : 2.0.6
Dependencies : Web


### 2)	Spring Initializer 로 시작
https://start.spring.io/


### 3)	Maven 으로 시작
손이 많이가서 권장하지 않는다. 그러나 한번쯤 경험해도 괜찮다.



## 6.	Hello World 작성
 
바로 ShopApllication Run! 에러 없으면 성공
 
HelloController 작성

    @RestController
    public class HelloController {
    	
    	@GetMapping("/")
    	public String hello() {
    		return "Hello World!";
    	}
    }


브라우저에서 http://localhost:8080/ 확인


## 7.	War 패키지로 바꿔보자.

### 1)	war 로 설정
pom.xml에서 <packaging>war</packaging>
war로 패키지로도 직접 실행이 가능하다.

### 2)	tomcat 추가
eclipse 서버에 tomcat 추가한다.

### 3)	Context root 설정
프로젝트 Properties - Web Project setting
Context root : /

### 4)	스프링 프레임워크 인식
그냥 톰캣에 프로젝트 심어서 실행하면 스프링 프레임워크가 인식이 안된다.

ServletInitializer 작성

    public class ServletInitializer extends SpringBootServletInitializer {
    
    	@Override
    	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    		return application.sources(ShopApplication.class);
    	}
    }

### 5)	브라우저에서 http://localhost:8080/ 확인


## 8.	jsp 활용


### 1)	HelloJspController 작성

    @Controller
    public class HelloJspController {
    
    	@GetMapping("/hello")
    	public String helloJsp() {
    		return "example/hello";
    	}
    }


### 2)	application.properties

    spring.mvc.view.prefix=/WEB-INF/jsp/
    spring.mvc.view.suffix=.jsp


### 3)	JSP 작성
src/main/webapp/WEB-INF/jsp/example 폴더 만들기

hello.jsp

    <%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    </head>
    <body>
    	<h1>Hello World</h1>
    	<h2>This is JSP</h2>
    </body>
    </html>

http://localhost:8080/hello 확인



### 4)	이클립스 main class runner 로 기동시 추가
스프링 의존성 관리에서 tomcat 라이브러리중에 jsp 를 변환해주는 라이브러리를 포함하지 않는다.

pom.xml

    <dependency>
    	<groupId>org.apache.tomcat.embed</groupId>
    	<artifactId>tomcat-embed-jasper</artifactId>
    	<scope>provided</scope>
    </dependency>


