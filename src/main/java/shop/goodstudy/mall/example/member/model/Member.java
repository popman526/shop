package shop.goodstudy.mall.example.member.model;

import java.util.List;

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
	@NonNull
	private List<String> roles;
	private List<String> roleNames;
}
