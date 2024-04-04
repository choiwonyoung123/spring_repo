package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
//junit 단위테스트 >> 메소드별 하나의 테스트로 진행
//어노테이션 추가하면 테스트와 관련된 내용 가져옴
//src/main/java에 있는 매퍼 정보도 불러올수 있음
//@Test 안붙이면 실행x
class Boot240403ApplicationTests {
	@Autowired //컨테이너 주입
	EmpMapper empMapper; //bean 사용

	//@Test
	void contextLoads() {
	}
	
	@Test
	void empAllList() { //전체조회 메소드
		List<EmpVO> list = empMapper.selectEmpAll(); //bean 사용
		assertTrue(!list.isEmpty()); //junit 테스트 >> 참인지 확인
	}
	
	@Test
	void empInsert() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("kdHong@google.com");
		empVO.setJobId("IT_PROG");
		int result = empMapper.insertEmp(empVO);
		assertEquals(1, result); //junit 테스트 >> 두 값이 같은지 확인
	}
}
