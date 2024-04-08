package com.yedam.app.dept.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class DeptController {
	
	@Autowired
	DeptService deptService;
	// 전체조회
	@GetMapping("deptList")
	public String deptList(Model model) {
		List<DeptVO> list = deptService.deptList();
		model.addAttribute("deptList", list);
		return "dept/list";
	}
	// 단건조회
	@GetMapping("deptInfo")
	public String deptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.deptInfo(deptVO);
		model.addAttribute("deptInfo", findVO);
		return "dept/info";
	}
	// <<등록 페이지>>
	@GetMapping("deptInsert") // GET 방식 정의, 경로 - empInsert
	public String deptInsertForm(Model model) { // 모델필요
		model.addAttribute("deptVO", new DeptVO()); // empInsertProcess로 데이터 이동
		return "dept/insert";
	}
	// <<등록 처리>>
	@PostMapping("deptInsert") // POST 방식 정의, 경로 - empInsert
	public String deptInsertProcess(DeptVO deptVO) { // 매개변수로 커맨드 객체 사용
		int dId = deptService.deptInsert(deptVO);
		String uri = null;
		if(dId > -1) {
			uri = "redirect:deptInfo?departmentId="+dId;
		}
		else {
			uri = "deptList";
		}
		return uri;
	}
}
