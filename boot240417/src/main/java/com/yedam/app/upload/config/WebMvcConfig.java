package com.yedam.app.upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	// 인터셉터 등록
	// 뷰리졸버 등록
	// 리소스 핸들링 처리
	@Value("${file.upload.path}") // application.properties에서 경로 미리 변수로 지정
	private String uploadPath; // 필드에 value값 들어감
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) { // 메소드 체이닝 >> 계속 추가 가능
		registry.addResourceHandler("/images/**").addResourceLocations("file:///" + uploadPath); // 경로, 물리적위치(file///), locations라서 콤마로 여러개 등록 가능
	}	
}
