package shop.goodstudy.mall;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/home", "/joinform", "/member/join").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/loginform")
				.loginProcessingUrl("/performlogin")
				.usernameParameter("memberId")
				.defaultSuccessUrl("/home")
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/home")
				.permitAll()
				.and()
			.sessionManagement()
				.maximumSessions(1)
				.expiredUrl("/loginform");
	}
	
	

//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		UserDetails user = 
//			User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(user);
//		
//	}
	
	@Bean
	@SuppressWarnings("deprecation")
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		// sha-256 암호화를 사용하고 싶은 경우
//		String encodingId = "SHA-256";
//		Map<String, PasswordEncoder> encoders = new HashMap<>();
//		encoders.put(encodingId, new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-256"));
//		
//		return new DelegatingPasswordEncoder(encodingId, encoders);
	}
	
}
