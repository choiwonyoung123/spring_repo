package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@RestController // @Controller + @ResponseBody(ajax) >> 암묵적으로 @ResponseBody(ajax)이 적용됨
public class EmpRequestController {
	@Autowired
	EmpService empService;
	
	// 페이지x >> 모델x
	
	// 전체조회 >> rest방식 >> 
	@GetMapping("emps") // 자원 >> 데이터 출력
	public List<EmpVO> empList(){
		return empService.empList();
	}
	
	// 단건조회
	@GetMapping("emps/{id}") // 경로에 아이디 붙여서 전달 >> @PathVariable, 파라미터 형태 >> {id} = 값이라는 것을 의미
	public EmpVO empInfo(@PathVariable(name="id") Integer employeeId) { // @pathvariable >> 매개변수명과 경로명이 다르면 name 속성 사용 >> 값 반드시 필요
		EmpVO findVO = new EmpVO(); // 인스턴스 생성
		findVO.setEmployeeId(employeeId); // 인스턴스에 사원번호 추가
		return empService.empInfo(findVO); // 매퍼 결과 반환(페이지x)
	}
	
	// 등록 post
	@PostMapping("emps")
	public int empInsert(@RequestBody EmpVO empVO) { // @RequestBody >> json 포맷으로 데이터 받기 >> 데이터 필요
		return empService.empInsert(empVO); // 매퍼 결과 반환(페이지x)
	}
	
	// 수정 put >> 경로=수정대상, 바디=수정정보
	@PutMapping("emps/{id}") // 경로에 아이디 붙여서 전달 >> @PathVariable, 파라미터 형태 >> {id} = 값이라는 것을 의미
	public Map<String, Object> empUpdate(@PathVariable(name="id") Integer employeeId, @RequestBody EmpVO empVO) { // @pathvariable >> 매개변수명과 경로명이 다르면 name 속성 사용 >> 값 반드시 필요
		empVO.setEmployeeId(employeeId); // 인스턴스에 사원번호 추가
		return empService.empUpdate(empVO); // 매퍼 결과 반환(페이지x)
	}
	
	// 삭제 delete >> 바디x
	@DeleteMapping("emp/{id}")
	public Map<String, Object> empDelete(@PathVariable Integer id){
		EmpVO findVO = new EmpVO(); // 인스턴스 생성
		findVO.setEmployeeId(id); // 인스턴스에 사원번호 추가
		return empService.empDelete(findVO); // 매퍼 결과 반환(페이지x)
	}
}
