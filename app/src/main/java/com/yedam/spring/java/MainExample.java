package com.yedam.spring.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		//인스턴스 생성 >> 컨테이너 완성 >> bean 등록
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		//클래스이름 자체를 가지고 bean 찾기
		//하나의 인스턴스를 bean으로 가져와서 변수에 할당
		Restaurant res = (Restaurant)ctx.getBean(Restaurant.class);
		Restaurant res2 = (Restaurant)ctx.getBean(Restaurant.class);
		
		if(res == res2) {
			System.out.println("동등");
		}
		else {
			System.out.println("다름");
		}
		//restaurant 메소드 호출
		res.run();
		res2.run();
	}
}
