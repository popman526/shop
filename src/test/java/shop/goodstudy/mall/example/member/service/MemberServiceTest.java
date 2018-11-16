package shop.goodstudy.mall.example.member.service;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import shop.goodstudy.mall.example.member.model.Member;

@SpringBootTest
@RunWith(SpringRunner.class)
//@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Slf4j
public class MemberServiceTest {
	
//	private static final Logger log = LoggerFactory.getLogger(memberServiceTest.class);
	
	@Autowired
	MemberService service;

	@Test
	public void test01_findById() {
		Member member = service.findById(1L);
		log.info("member : {}", member);
	}
	
	@Test
	public void test02_findAllmember() {
		List<Member> members = service.findAll();
		log.info("member : {}", members);
	}

	@Test
	public void test03_addmember() {
		int a = service.add(new Member("admin", "관리자", "admin"));
		int b = service.add(new Member("member1", "회원1", "member"));
		List<Member> members = service.findAll();
		
		log.info("a : {}", a);
		log.info("b : {}", b);
		log.info("member : {}", members);
	}
	
	@Test
	public void test04_modifymember() {
		int a = service.modify(new Member(2L, "admin", "관리자", "admin"));
		int b = service.modify(new Member(3L, "member01", "회원01", "member"));
		List<Member> members = service.findAll();
		
		log.info("a : {}", a);
		log.info("b : {}", b);
		log.info("member : {}", members);
	}
	
	@Test
	public void test05_deletemember() {
		int a = service.delete(new Member(3L, "member01", "회원1", "member"));
		
		List<Member> members = service.findAll();
		log.info("a : {}", a);
		log.info("member : {}", members);
	}
	

}
