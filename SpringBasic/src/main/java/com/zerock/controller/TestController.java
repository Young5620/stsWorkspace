package com.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/test/*")
public class TestController {

	/*
	@RequestMapping(value="/req_ex01") 
	public void req_ex01() { 
		//화면처리: @RequestMapping으로 지정된/test/req_ex01로 전달... 
		System.out.println("Void메서드의 페이지 이동: req_ex01 테스트");
	} 
	*/ 
	
	 //일반적으로 가장 많이 사용하는 case 
	 //return 값에 경로 정보를 다 넣어야해!!  
	@RequestMapping(value="/req_ex01") 
	public String req_ex01() {  
		
	//return값으로 넘길 땐 test경로를 설정해줘야함
	return "test/req_ex01";
		
	}

	//3번째를 통해 2번째를 실행한다.  
	@RequestMapping(value="/test") 
	public String req_ex01_re() {
	
	System.out.println("리다이렉트 처리!!");
	
	return "redirect:req_ex01"; 
	}
	
	
	
	
	
}
