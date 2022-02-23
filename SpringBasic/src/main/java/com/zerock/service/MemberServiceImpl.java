package com.zerock.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zerock.command.MemberVO;

//Injection할 대상, Service Annotation에 value 값을 생략했을뿐
@Service("memberService")
public class MemberServiceImpl implements MemberService {

	//DB가 없기 떄문에 회원정보 저장할 저장소 ArrayList생성
	ArrayList<MemberVO> memberList = new ArrayList<MemberVO>(); 
	//ArrayList<MemberVO> memberList = new ArrayList<>(); 
	
	//회원가입처리
	@Override
	public void insertMember(MemberVO vo) {
		memberList.add(vo); 
	}

	//로그인 유효성검사
	@Override
	public int memberCheck(MemberVO vo) {
		
		int result= 0; 
		
		for(MemberVO dbVO:memberList) {
			if(dbVO.getId().equals(vo.getId())) { 
				String dbPw= dbVO.getPw(); 
				String pw= vo.getPw();
				
				if(dbPw.equals(pw)) { 
					result=1; 
				}
			} 
		}
		return result;
	}
	
}
