package shop.goodstudy.mall.example.member.model;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Alias("member")
public class Member {
	private Long id;
	@NonNull
	private String memberId;
	@NonNull
	private String name;
	@NonNull
	private String password;
	
	// TODO 추후 다중 role 등록으로 수정
	@NonNull
	private String role;
}
