package shop.goodstudy.mall.example.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shop.goodstudy.mall.example.member.mapper.MemberMapper;
import shop.goodstudy.mall.example.member.model.Member;
import shop.goodstudy.mall.example.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService/*, UserDetailsService*/ {
	
	@Autowired
	MemberMapper memberMapper;

	@Override
	public Member findById(Long id) {
		return memberMapper.findById(id);
	}

	@Override
	public Member findByMemberId(String memberId) {
		return memberMapper.findByMemberId(memberId);
	}

	@Override
	public List<Member> findAll() {
		return memberMapper.findAll();
	}

	@Override
	public int add(Member member) {
		return memberMapper.add(member);
	}

	@Override
	public int modify(Member member) {
		return memberMapper.modify(member);
	}

	@Override
	public int delete(Member member) {
		return memberMapper.delete(member);
	}
/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberMapper.findByMemberId(username);
		
		return null;
	}*/


}
