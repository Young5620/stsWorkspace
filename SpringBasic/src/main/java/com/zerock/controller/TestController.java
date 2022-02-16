package com.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/*") //test/* 이후에 모든 내용을 매핑하는 Controller
public class TestController {
	
	/*@RequestMapping(value="req_ex01")	
	 * public void req_ex01() { //@RequestMapping으로 지정된 /test/req_ex01로 전달...
	 * System.out.println("void메서드의 페이지 이동"); }
	 */
	
	// return 값에 경로 정보를 더 넣어야 한다!
	 @RequestMapping(value="/req_ex01") 
	 public String req_ex01() { 
	  return "test/req_ex01"; 
	  }
	 
	
	@RequestMapping(value="/test")
	public String req_ex01_re() {
		System.out.println("리다이렉트 처리");
		return "redirect:req_ex01";
		//return "test/req_ex011";
	}
	
}
