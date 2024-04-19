package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yedam.app.aop.service.AaaService;

@SpringBootTest
class Boot240417ApplicationTests {
	
	@Autowired
	AaaService aaaService;
	
	//@Test
	public void aopTest() {		
		aaaService.insert();
	}
	
	@Autowired
	PasswordEncoder passwordEncoder; // 단방향 암호화 >> 복구 불가능
	
	@Test
	public void testEncoder() {
		String password = "1234"; // 비밀번호
		
		String enPwd = passwordEncoder.encode(password); // 암호화
		System.out.println("enPwd : " + enPwd);
		
		boolean matchResult = passwordEncoder.matches(password, enPwd); // 원래 비밀번호, 암호화된 비밀번호 >> 로그인시 판단 가능
		System.out.println("matchResult : " + matchResult);
	}
}
