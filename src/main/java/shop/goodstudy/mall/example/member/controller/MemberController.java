package shop.goodstudy.mall.example.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.goodstudy.mall.example.member.model.Member;
import shop.goodstudy.mall.example.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/memberslist")
	public String memberslist() {
		return "example/member/memberslist";
	}
	
	@GetMapping("/joinform")
	public String join() {
		return "example/member/joinform";
	}
	
	@GetMapping("/login")
	public String loginform() {
		return "example/member/loginform";
	}
	
	@PostMapping("/member/join")
	public String join(Member member) {
		memberService.add(member);
		return "redirect:/memberslist";
	}
}