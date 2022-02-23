package com.zerock.mybatisTest;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.command.ScoreVO;
import com.zerock.testmapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisSelect {
	//DAO로 가정작업
	//MyBatis 매퍼(Mapper 스캔추가해야함.매퍼 인터페이스, 매퍼 XML이 있어야 동작)  
	@Autowired
	private TestMapper mapper; 
	
	@Test //단위테스트
	public void select () { 
		
		String time= mapper.getTime();
		System.out.println(time);
		
		ArrayList<ScoreVO> list= mapper.select();
		for(ScoreVO vo:list) {  
			System.out.println(vo.getNum());
			System.out.println(vo.getName());
			System.out.println(vo.getKor());
			System.out.println(vo.getEng());
			System.out.println(vo.getMath());
			System.out.println("-------------------");
		}
	} 

}
