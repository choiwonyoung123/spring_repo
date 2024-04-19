package com.yedam.app.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.app.security.mapper.UserMapper;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	UserMapper userMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // 인증 확인
		UserVO userVO = userMapper.getUserInfo(username);
		if(userVO == null) {
			throw new UsernameNotFoundException("NO User"); // 별도 처리x, security가 낚아챔 >> "자격 증명에 실패하였습니다" 메시지와 비슷, 예외 처리, 자바 기준
		}
		return new LoginUserVO(userVO);
	}
	
}
