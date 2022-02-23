package com.zerock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.command.JoinVO;
import com.zerock.command.MemberVO;
import com.zerock.service.JoinService;
import com.zerock.service.MemberService;

@Controller
@RequestMapping("/service/*")
public class MemberServiceController {
	
	//인터페이스에 의존성 주입
	@Autowired
	MemberService memberService; 
	
	@Autowired
	JoinService joinService;
	
	//로그인 입력페이지 
	@RequestMapping("/member_ex01") 
	public String member_ex01() { 
		
		return "service/member_ex01";
	}
	
	//회원가입 페이지
	@RequestMapping("/member_ex00") 
	public String member_ex00() { 
		
		
		return "service/member_ex00";
	}

	//회원가입처리 메서드 
	//@RequestMapping("join")
	//public String join(MemberVO vo) { 
		
	//	memberService.insertMember(vo);
		
	//	return "service/member_ex02";
	//}
	
	//회원로그인 화면처리
	@RequestMapping("/member_ex03")
	public String member_ex03() { 
		
		
		return "service/member_ex03"; 
	} 
	
	//로그인 메서드 처리
	@RequestMapping("login")
	public ModelAndView login(MemberVO vo, Model model, RedirectAttributes RA) { 
	
	//로그인 유효성 검사(서비스로 아이디를 전달) 
	int result=	memberService.memberCheck(vo); 
	ModelAndView mav= new ModelAndView(); //ModelAndView객체선언
	
	if (result ==1) {//로그인 성공 
		//model.addAttribute("memberInfo",vo); //modelandview로 변경
		mav.addObject("memberInfo", vo); 
		mav.setViewName("service/member_mypage");
		
	return mav;//성공 시 마이페이지 이동
	
	} else { //로그인 실패  
		RA.addFlashAttribute("msg","아이디 또는 비밀번호 확인해주세요"); 
		mav.setViewName("redirect:/service/member_ex03");
		
	return mav; //실패 시 로그인페이지 이동
	}
	} 

	@RequestMapping("/join")
	public ModelAndView member_join(JoinVO vo, MemberVO vo2, Model model) { 
		ModelAndView mav= new ModelAndView();
		joinService.joinMember(vo); 
		
		mav.addObject("memberInfo", vo); 
		mav.setViewName("service/member_ex03");
		
		
		memberService.insertMember(vo2);
		return mav;
	} 
	
	
	
	
	@RequestMapping(value="/memlogin", method=RequestMethod.POST)
	public String memlogin(Model model, HttpServletRequest request) { 
		
	String memid= request.getParameter("memid"); 
	String mempw= request.getParameter("mempw");	
		
	model.addAttribute("memId",memid); 
	model.addAttribute("memPw",mempw); 
	
	return "service/result"; 
	}  
	
	//RequestParam 어노테이션을 이용한 HTTP 전송정보 얻기
	@RequestMapping(value="/memlogin2", method=RequestMethod.POST)
	public String memlogin2(Model model, 
			@RequestParam("memid") String memid,
			@RequestParam("mempw") String mempw
			) { 
		
	model.addAttribute("memId",memid); 
	model.addAttribute("memPw",mempw); 
	
	return "service/result"; 
	
	}  
	
	//커멘드를 이용한 HTTP전송 정보처리(MemberVO를 이용한 vo값으로 전달받기)  
	@RequestMapping(value="/memlogin3", method=RequestMethod.POST)
	public String memlogin3(Model model, MemberVO vo) { 
	System.out.println(vo.getId());
	System.out.println(vo.getPw());
	
	model.addAttribute("memId",vo.getId()); 
	model.addAttribute("memPw",vo.getPw()); 
	model.addAttribute("memName",vo.getName()); 
	
	return "service/result"; 
		
	} 
	
	
	
	
	
}
