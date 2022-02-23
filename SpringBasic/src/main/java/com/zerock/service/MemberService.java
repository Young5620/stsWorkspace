package com.zerock.service;

import org.springframework.stereotype.Service;

import com.zerock.command.MemberVO;


public interface MemberService {

	public void insertMember(MemberVO vo); //회원가입처리
	public int memberCheck(MemberVO vo); //회원확인 

	
}
