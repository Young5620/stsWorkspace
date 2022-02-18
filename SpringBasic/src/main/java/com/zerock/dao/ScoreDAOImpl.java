package com.zerock.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zerock.command.ScoreVO;

//DAO의 객체 주입은 일반적으로 Component나 Repository 어노테이션을 사용한다.
//component-scan에 꼭 추가해준다.

//@Component
@Repository("scoreDAO")
public class ScoreDAOImpl implements ScoreDAO {
	
	//DB를 대신할 저장소
	ArrayList<ScoreVO> DB = new ArrayList<ScoreVO>();

	@Override //점수입력 메서드
	public void scoreInsert(ScoreVO vo) {
		System.out.println("=====DAO계층====="); 
		 System.out.println(vo.getName());
		 System.out.println(vo.getKor()); 
		 System.out.println(vo.getEng());
		 System.out.println(vo.getMath());
		 DB.add(vo);
		 System.out.println("현재 게시물 수 : " + DB.size());
	}

	@Override //점수 결과 출력 메서드
	public ArrayList<ScoreVO> scoreSelect() {
		
		return DB;
	}

	@Override //점수 삭제 메서드
	public void scoreDelete(String num) {
		int index = Integer.parseInt(num);
		DB.remove(index);
	}

}
