package com.yedam.java.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yedam.java.emp.service.EmpService;
import com.yedam.java.emp.service.EmpVO;

@Controller //controller 어노테이션 추가
public class EmpController {
	@Autowired
	EmpService empService;
	
	@RequestMapping(path="empList", method = RequestMethod.GET) //emp 경로
	public String empList(Model model) {
		List<EmpVO> list = empService.empAllList(); //service 메소드 연결
		model.addAttribute("empList", list); //moder = req + resp, empList 데이터 전달
		return "empList"; //jsp파일 이름
	}
}
