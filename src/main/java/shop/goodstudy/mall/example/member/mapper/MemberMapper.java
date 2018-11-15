package shop.goodstudy.mall.example.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.example.member.model.Member;

@Mapper
public interface MemberMapper {
	Member findById(Long id);
	Member findByMemberId(String memberId);
	List<Member> findAll();
	int add(Member member);
	int modify(Member member);
	int delete(Member member);
}
