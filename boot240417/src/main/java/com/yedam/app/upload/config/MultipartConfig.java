package com.yedam.app.upload.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class MultipartConfig {
	// 설정 빈
	@Bean // 메소드 실행결과 빈으로 등록
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver(); // 구현 부분
	}
	
	// 스프링 부트 3버전 >> 파일 처리 빈
	@Bean
	public MultipartConfigElement multipartConfiElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxRequestSize(DataSize.ofMegabytes(10)); // 파일 크기
		factory.setMaxFileSize(DataSize.ofBytes(0)); // 파일 크기
		
		return factory.createMultipartConfig(); // 메소드로 반환하는 메소드
	}
}
