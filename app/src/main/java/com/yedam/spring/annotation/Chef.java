package com.yedam.spring.annotation;

import org.springframework.stereotype.Component;

//어노테이션 방식, 이름 지정
@Component
public class Chef {
	public void coocking() {
		System.out.println("annotation 방식");
	}
}
