package com.zerock.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zerock.command.ScoreVO;
import com.zerock.mapper.ScoreMapper;

//@Service
@Service("scoreService")  //해당 클래스를 컨테이너에 빈으로 생성하겠다는 어노테이션
public class ScoreServiceImpl implements ScoreService {

//	ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
		
	//@Autowired 
	//private ScoreDAO scoreDAO;
	
	@Autowired
	private ScoreMapper mapper; 
	
	/*
	@Override
	public void scoreRegist(ScoreVO vo) {
		//vo(커멘드이름) 
		vo.getName(); 
		vo.getKor();
		vo.getEng();
		vo.getMath();
		//System.out.println("-------- 서비스 계층 ---------");
		//System.out.println(dao.getName());
		//System.out.println(dao.getKor());
		//System.out.println(dao.getEng());
		//System.out.println(dao.getMath());
		
		mapper.insert(vo);
	}
	*/
	
	
	@Override
	public void scoreRegist(ScoreVO vo) {
		Map<String,String> map= new HashMap<>(); 
		map.put("p1", vo.getName()); 
		map.put("p2", vo.getKor());
		map.put("p3", vo.getEng());
		map.put("p4", vo.getMath());
			
		boolean result= mapper.insert2(map); 
		System.out.println("insert결과:"+ result);
	}
	
	
	

	private String toString(int num) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public ArrayList<ScoreVO> scoreResult() {
		
		ArrayList<ScoreVO> DB= mapper.select(); 
		return DB;
	}

	@Override
	public void scoreDelete(String num) {
		mapper.delete(num);
		
	}

}
