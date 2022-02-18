package com.zerock.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.zerock.command.ScoreVO;
import com.zerock.dao.ScoreDAO;
import com.zerock.dao.ScoreDAOImpl;

//@Component //잘됨
//@Component("scoreService") //잘됨
//@Repository //잘됨
@Service("scoreService") //잘됨 해당클래스를 컨테이너에 반으로 생성하겠다는 어노테이션
public class ScoreServiceImpl implements ScoreService {

	//ArrayList<ScoreVO> list = new ArrayList<>();
	
	/*
	 * @Override 
	 * public void scoreRegist(ScoreVO dao) {
	 * System.out.println("=====서비스계층====="); 
	 * System.out.println(dao.getName());
	 * System.out.println(dao.getKor()); 
	 * System.out.println(dao.getEng());
	 * System.out.println(dao.getMath()); 
	 * list.add(dao);
	 * 
	 * System.out.println(list.toString()); 
	 * }
	 * 
	 * @Override 
	 * public ArrayList<ScoreVO> scoreResult() { 
	 * 		return list; 
	 * }
	 * 
	 * @Override 
	 * public void scoreDelete(String number) {
	 * 
	 * int num = Integer.parseInt(number);
	 * 
	 * list.remove(num); 
	 * }
	 */
	//------------DAO들어가기---------------
	
	//1번 스타일 - 객체생성
	//ScoreDAO scoreDAO = new ScoreDAOImpl();
	
	//2번 스타일 - Bean등록
//	@Autowired
//	ScoreDAO scoreDAO;
	
	//3번 스타일 - 자동 의존성 주입을 어노테이션을 이용하여...
	@Autowired
	private ScoreDAO scoreDAO;
	
	@Override
	public void scoreRegist(ScoreVO vo) {
		System.out.println("=====서비스계층====="); 
		 System.out.println(vo.getName());
		 System.out.println(vo.getKor()); 
		 System.out.println(vo.getEng());
		 System.out.println(vo.getMath());
		 
		 scoreDAO.scoreInsert(vo); //점수 입력 메서드 호출
	}
	
	@Override
	public ArrayList<ScoreVO> scoreResult() {
		ArrayList<ScoreVO> DB = scoreDAO.scoreSelect(); //점수 결과 메서드 호출
		return DB;
	}
	
	@Override
	public void scoreDelete(String num) {
		scoreDAO.scoreDelete(num); //점수 삭제 메서드 호출
	}

}
