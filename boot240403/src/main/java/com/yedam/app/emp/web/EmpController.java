package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

// 컨트롤 bean 등록
// 중간 역할
@Controller
public class EmpController {
	
	@Autowired // 서비스 주입
	EmpService empService;
	
	// GET 방식: 조회, 빈페이지(로그인 등)
	// POST 방식: 데이터 조작 관련(등록, 수정, 삭제)
	
	// <<전체조회>>
	@GetMapping("empList") // GET 방식 정의, 경로 - empList
	public String empList(Model model) { // 매개변수x, 모델필요(req + resp), 세션 필요시 매개변수로 세션 선언
		List<EmpVO> list = empService.empList(); // 서비스 메소드 호출, 변수에 추가
		model.addAttribute("empList", list); // model(req-resp)에 메소드 결과 값 추가
		return "emp/list"; // 출력 페이지 호출, classpath: > templates폴더 > emp폴더 > list파일
		// prefix - classpath:/templates/
		// subfix - .html
	}
	
	// <<단건조회>> 커맨드객체 requestparam
	@GetMapping("empInfo") // GET 방식 정의, 경로 - empInfo
	public String empInfo(EmpVO empVO, Model model) { // 매개변수로 커맨드 객체 사용(어노테이션x) >> 쿼리 스트링 사용, 모델필요
		EmpVO findVO = empService.empInfo(empVO); // 서비스 메소드 호출, 매개변수로 커맨드객체 넘기기
		model.addAttribute("empInfo", findVO); // model에 메소드 결과 값 추가
		return "emp/info"; // 출력 페이지 호출
	}
	
	// <<등록 페이지>>
	@GetMapping("empInsert") // GET 방식 정의, 경로 - empInsert
	public String empInsertForm(Model model) { // 모델필요
		model.addAttribute("empVO", new EmpVO()); // empInsertProcess로 데이터 이동
		return "emp/insert";
	}
	
	// <<등록 처리>>
	@PostMapping("empInsert") // POST 방식 정의, 경로 - empInsert
	public String empInsertProcess(EmpVO empVO) { // 매개변수로 커맨드 객체 사용
		int eId = empService.empInsert(empVO);
		String uri = null;
		if(eId > -1) {
			uri = "redirect:empInfo?employeeId="+eId;
		}
		else {
			uri = "empList";
		}
		return uri;
	}
}
