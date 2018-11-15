package shop.goodstudy.mall.example.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.goodstudy.mall.example.member.model.Member;
import shop.goodstudy.mall.example.member.service.MemberService;

@RestController
public class MemberRestController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/members")
	public List<Member> members() {
		return memberService.findAll();
	}
	
}
