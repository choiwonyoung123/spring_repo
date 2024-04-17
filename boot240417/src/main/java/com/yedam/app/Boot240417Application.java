package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링부트 시작점 >> 건드리지x

@SpringBootApplication // 어노테이션이 많은 것을 함축하고 있음
@MapperScan(basePackages = "com.yedam.app.**.mapper") // 매퍼를 포함하고 있지 않아서 추가로 mapperscan 어노테이션 추가
public class Boot240417Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot240417Application.class, args);
	}

}
