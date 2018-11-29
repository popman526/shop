package shop.goodstudy.mall.example.member.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import shop.goodstudy.mall.example.member.mapper.MemberMapper;
import shop.goodstudy.mall.example.member.model.Member;
import shop.goodstudy.mall.example.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

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
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		return memberMapper.add(member);
	}

	@Override
	public int modify(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		return memberMapper.modify(member);
	}

	@Override
	public int delete(Member member) {
		return memberMapper.delete(member);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberMapper.findByMemberId(username);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(member.getRole()));
		
		return new User(member.getMemberId(), member.getPassword(), authorities);
		
		/*UserDetails userDatails = new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				return true;
			}
			
			@Override
			public String getUsername() {
				return member.getMemberId();
			}
			
			@Override
			public String getPassword() {
				return member.getPassword();
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
				return authorities;
			}
		};
		
		return userDatails;*/
	}


}
