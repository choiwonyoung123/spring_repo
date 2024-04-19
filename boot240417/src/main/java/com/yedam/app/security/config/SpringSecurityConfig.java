package com.yedam.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	// 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// 메모리상 인증정보 활용 >> 코드로 직접 아이디 패스워드 넣어서 사용
	//@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsService() {
		UserDetails user = User.builder()
				.username("user1")
				.password(passwordEncoder().encode("1234"))
				.roles("USER")
				.build(); // roles("USER") = role_USER >> role이 자동으로 붙음, authorities("ROLE_USER") = role을 붙여줘야 함, roles 메소드 안에 여러개 가능
		return new InMemoryUserDetailsManager(user);
	}
	
	// 인증 및 인가 설정
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
		.antMatchers("/", "/all").permitAll()
		.antMatchers("/user/**").hasAnyRole("USER", "ADMIN") // hasAnyRole, hasRole, 사용자 계정은 사용자 또는 관리자 모두 접근 가능
		.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN") // 관리자 계정은 관리자만 접근 가능
		.anyRequest().authenticated() // 인증받지 않은 모든 사람에게 허용, 인증된 대상만 접근
		.and() // 붙여 쓰기 가능
		.formLogin().defaultSuccessUrl("/all") // 로그인 한 경우 all 페이지로 이동
		.and()
		.logout().logoutSuccessUrl("/all"); // 로그아웃 한 경우 all 페이지로 이동
		
		// 구분해서 작성 가능
		//http.formLogin().defaultSuccessUrl("all"); // 로그인한 경우 all 페이지로 이동
		//http.logout();
		
		// CSRF >> 서버 요청시 get메소드 제외하고 토큰 필요로 함
		//http.csrf().disable();
		http.csrf();
		
		return http.build();
	}
}
