package shop.goodstudy.mall.example.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRolesMapper {
	List<String> findByMemberId(String id);
}
