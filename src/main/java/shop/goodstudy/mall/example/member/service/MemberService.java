package shop.goodstudy.mall.example.member.service;

import java.util.List;

import shop.goodstudy.mall.example.member.model.Member;

public interface MemberService {
	Member findById(Long id);
	Member findByMemberId(String memberId);
	List<Member> findAll();
	int add(Member member);
	int modify(Member member);
	int delete(Member member);
}
