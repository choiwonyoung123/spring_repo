package com.yedam.spring.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//인스턴스 설정과 관련된 클래스 >> -config
@Configuration
public class JavaConfig {
	//메소드로 bean 등록 >> 메소드 실행 >> 인스턴스 생성
	@Bean(name="chf") //이름=속성, 호출시 사용
	public Chef chef() {
		return new Chef();
	}
	@Bean
	public Restaurant restaurant(Chef chef) {
		Restaurant res = new Restaurant();
		res.setChef(chef);
		return res;
	}
}
