package com.zerock.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zerock.command.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	ArrayList<MemberVO> memberList = new ArrayList<>(); //회원정보 저장할 저장소(임시)
	
	
	//회원가입 처리
	@Override
	public void insertMember(MemberVO vo) {
		memberList.add(vo);
	}
	
	//로그인 유효성 검사
	@Override
	public int memberCheck(MemberVO vo) {
		int result = 0;
		for(MemberVO dbVO : memberList) {
			if(dbVO.getId().equals(vo.getId())) {
				String dbPw = dbVO.getPw();
				String pw = vo.getPw();
				if(dbPw.equals(pw)) {
					result = 1;
				} else {
					result = 0;
				}
			}
		}
		return result;
	}

}
