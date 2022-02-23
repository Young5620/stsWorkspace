package com.zerock.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zerock.command.JoinVO;


@Service("joinService")
public class JoinServiceImpl implements JoinService {

	ArrayList<JoinVO> joinList = new ArrayList<JoinVO>(); 
	
	//회원가입처리
	@Override
	public void joinMember(JoinVO vo) {
		joinList.add(vo); 
		
		
	}

	//회원가입 유효성검사
	@Override
	public int joinCheck(JoinVO vo) {
			 
		int result= 0;
		
		return result;
	}
	
	
	
	
	
	
	
}
