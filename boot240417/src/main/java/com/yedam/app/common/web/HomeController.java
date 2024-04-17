package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러 어노테이션
public class HomeController {
	@GetMapping("/") // 페이지 주소 매핑 
	public String homePage() {
		return "home"; // 뷰 페이지 호출
		// classpath:/templates/home.html 경로 >> viewresolver 역할
	}
}
