package com.yedam.app.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUserVO implements UserDetails{

	private UserVO userVO;
	
	public LoginUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { // 권한 가져오기, collection >> list, set 타입 최상위 클래스
		List<GrantedAuthority> auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority(userVO.getRoleName()));
		return auth;
	}
	
	// userdetails >> set 없음, readonly, 정보 확인용 메소드
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userVO.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userVO.getLoginId();
	}

	@Override
	public boolean isAccountNonExpired() { // 계정 만료 여부
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // 계정 잠금 여부
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // 계정 패스워드 만료 여부
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() { // 계정 사용 여부
		// TODO Auto-generated method stub
		return true;
	}

}
