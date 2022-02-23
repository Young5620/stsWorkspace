package com.zerock.testmapper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

import com.zerock.command.ScoreVO;

public interface TestMapper {
	
	public String getTime(); //서버시간 알아오기 
	public ArrayList<ScoreVO> select(); 
	public boolean insert(ScoreVO vo);
	public boolean insert2(Map<String,String> map);
	
	
	
}
