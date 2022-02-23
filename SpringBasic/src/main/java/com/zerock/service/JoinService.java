package com.zerock.service;

import com.zerock.command.JoinVO;


public interface JoinService {


	
	public void joinMember(JoinVO vo); //회원가입처리
	public int joinCheck(JoinVO vo); //회원확인 

	
}
