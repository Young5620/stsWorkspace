package com.zerock.dao;

import java.util.ArrayList;

import com.zerock.command.ScoreVO;

public interface ScoreDAO {

	public void scoreInsert(ScoreVO vo); //점수입력 메서드 
	public ArrayList<ScoreVO> scoreSelect(); //점수저장 결과보기 메서드 
	public void scoreDelete(String num); //점수삭제 메서드 
	

	
	
}
