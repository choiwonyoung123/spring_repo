package com.yedam.app.home;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin // cors
@Slf4j
@Controller
public class HomeController {	
	// -- 쿼리 스트링 --
	// queryString >> 커맨드객체
	// method >> 상관없음
	// content-type >> application/x-www-form-urlencoded
	@RequestMapping(path="comobj", method= {RequestMethod.GET, RequestMethod.POST}) // 기본 >> path,method 필수
	@ResponseBody
	public String commandObject(EmpVO empVO) {
		log.info("path: /comobj");
		log.info("= employee_id: " + empVO.getEmployeeId());
		log.info("= last_name: " + empVO.getLastName());
		log.info(empVO.toString());
		return "";
	}
	// -- 쿼리 스트링 --
	@RequestMapping(path="reqparm", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	// @RequestParam >> 필수일때 추가
	// @RequestParam(name="", defaultValue="", required="")
	public String requestParam(@RequestParam Integer employeeId, String lastName, @RequestParam(name="message", defaultValue="No message", required=false) String msg) {
		log.info("path: /reqparm");
		log.info("= employee_id: " + employeeId);
		log.info("= last_name: " + lastName);
		log.info("= msg: " + msg);
		return "";
	}
	// -- pathVariable >> rest(단건조회/수정) --
	// path variable >> 경로에 변수 추가, 어떤 데이터인지 모름, 제한된 값만 보낼때 사용(기본타입 매개변수, 객체x, 여러개x)
	// post 방식은 데이터가 필요하지만 이 방법은 데이터 필요x, 메소드 - 콘텐트타입 상관x
	@RequestMapping(path="path/{id}")
	@ResponseBody
	public String pathVariable(@PathVariable String id) {
		log.info("path: /path/{id}");
		log.info("= id: " + id);
		return "";
	}
	// -- rest --
	@PostMapping("resbody") // post,put
	@ResponseBody // json데이터포맷
	public Map<String, Object> requestBody(@RequestBody EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		map.put("path", "resbody");
		map.put("data", empVO);
		return map;
	}
}
