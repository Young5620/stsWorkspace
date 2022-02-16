package com.zerock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.command.MemberVO;
import com.zerock.service.MemberService;

@Controller
@RequestMapping(value="/service/*")
public class MemberServiceController {
	
	@Autowired
	MemberService memberService;
	
	//화면처리(연습)
	@RequestMapping(value="/member_ex01")
	public String member_ex01() {
		return "service/member_ex01";
	}
	
	//화면처리(회원가입)
	@RequestMapping(value="/member_ex00")
	public String member_ex00() {
		return "service/member_ex00";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(MemberVO vo) {
		return "service/member_ex02";
	}
	
	@RequestMapping(value="/memlogin", method=RequestMethod.POST)
	public String memlogin(Model model, HttpServletRequest request) {
		String memid = request.getParameter("memId");
		String mempw = request.getParameter("memPw");
		model.addAttribute("memId", memid);
		model.addAttribute("memPw", mempw);
		return "service/result";
	}
	
	//RequestParam
	@RequestMapping(value="/memlogin2", method=RequestMethod.POST)
	public String memlogin2(Model model, @RequestParam("memId") String memid, @RequestParam("memPw") String mempw) {
		model.addAttribute("memId", memid);
		model.addAttribute("memPw", mempw);
		return "service/result";
	}
	
	//커멘드를 이용한 HTTP전송 정보처리
	@RequestMapping(value="/memlogin3", method=RequestMethod.POST)
	public String memlogin3(Model model, MemberVO vo) {
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		model.addAttribute("memId", vo.getId());
		model.addAttribute("memPw", vo.getPw());
		model.addAttribute("memName", vo.getName());
		return "service/result";
	}
	
}
