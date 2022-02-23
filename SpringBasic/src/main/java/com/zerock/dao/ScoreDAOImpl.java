package com.zerock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zerock.command.BoardVO;
import com.zerock.command.ScoreVO;

//DAO객체주입은 일반적으로 Component나 Repository Annotation을 사용합니다.  
//Component-scan에 꼭 추가해준다. 
	
//@Component
@Repository("scoreDAO")
public class ScoreDAOImpl implements ScoreDAO {
	
	//DB를 대신할 저장소 
	@Autowired
	private JdbcTemplate jdbcTemplate; 	
	
	//DB를 대신할 저장소필요(DB로 가정)  
	//ArrayList<ScoreVO> DB = new ArrayList<ScoreVO>(); 
	
	@Override //점수입력메서드
	public void scoreInsert(ScoreVO vo) {
		
		String sql="INSERT INTO SCORE01(name,kor,eng,math) values(?,?,?,?)"; 
	
		System.out.println("----DAO계층---------");
		System.out.println(vo.getName());
		System.out.println(vo.getKor()); 
		
		int result = jdbcTemplate.update(sql, new Object[] {
				vo.getName(),
				vo.getKor(),
				vo.getEng(),
				vo.getMath()});
		System.out.println("입력결과 확인:" +result);
		 
		
		//DB.add(vo);
		//System.out.println("현재 게시물 수: " + DB.size());
	
	}
	

	@Override //점수결과 출력메서드
	public ArrayList<ScoreVO> scoreSelect() {

		/*
		query()의 파라미터 의미
		-sql : sql쿼리, preparedStatement방식의 ? 값
		-new Object[] {값1, 값2} : sql물음표에 셋팅값을 지정(바인딩)
		-new RowMapper<type>: 조회결과 ResultSet으로부터 데이터를 읽어와 type데이터를 생성
			->익명 클래스 사용 
			->mapRow() 메서드는 ResultSet에서 읽어온 값을 처리한 후에 리턴한다.
		*/
		
		String sql= "select * from score01 order by num";
		List<ScoreVO> list= jdbcTemplate.query(sql, new Object[] {}, new RowMapper<ScoreVO>() { 
		
			@Override
			public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {  
				
				ScoreVO vo = new ScoreVO(); //빈 객체선언(ScoreVO) 
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getString("kor"));
				vo.setEng(rs.getString("eng"));
				vo.setMath(rs.getString("math"));
				return vo;
			}
		});
		return (ArrayList<ScoreVO>) list;
	}

	@Override //점수삭제 메서드 
	public void scoreDelete(String num) {
	
		String sql = "DELETE FROM SCORE01 WHERE NUM=?";
		
		int result= jdbcTemplate.update(sql,new Object[] {num});
		System.out.println("삭제결과확인"+result);
		//ArrayList<ScoreVO> DB = new ArrayList<ScoreVO>();
		//int index = Integer.parseInt(num);
		//DB.remove(index); //DB삭제

		
	}

	
	
	
	
	
	
}
