package com.zerock.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zerock.command.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	ArrayList<MemberVO> memberList = new ArrayList<>();
	
	
	//회원가입 처리
	@Override
	public void insertMember(MemberVO vo) {
		memberList.add(vo);
		System.out.println();
	}
	
	//로그인 유효성 검사
	@Override
	public int memberCheck(MemberVO vo) {
		return 0;
	}

}
