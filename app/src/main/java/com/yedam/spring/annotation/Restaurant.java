package com.yedam.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//어노테이션 방식
@Component
public class Restaurant {
	
	private Chef chef;
	
	//chef 메소드 호출
	public void run() {
		chef.coocking();
	}

	public Chef getChef() {
		return chef;
	}
	
	//의존성 주입 >> lombok 사용시 필드에 주입
	@Autowired
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
}
