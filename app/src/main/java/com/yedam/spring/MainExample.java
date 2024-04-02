package com.yedam.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		//컨테이너 만들기
		//classpath >> bean 등록한 xml 파일명
		//classpath(미리정의한파일,resources) or file(물리적인위치,src)
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		//스프링으로 자동 생성, 인스턴스 직접 생성x
		TV tv = (TV)ctx.getBean("tv");
		tv.turnOn();
	}
}
