package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//기준

@SpringBootApplication //component-scan + enableautoconfiguration + springbootconfiguration >> 건들지x
@MapperScan(basePackages = "com.yedam.app.**.mapper") //mapper 설정 >> 어노테이션 방식
//루트패키지 >> compnentScan
public class Boot240403Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot240403Application.class, args); //자바프로젝트로 인식
	}

}
