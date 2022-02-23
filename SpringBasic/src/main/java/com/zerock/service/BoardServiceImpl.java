package com.zerock.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.command.BoardVO;
import com.zerock.dao.BoardDAO;
import com.zerock.dao.BoardDAOImpl;
import com.zerock.mapper.BoardMapper;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper; 
	
	//DAO 자동주입
	//@Autowired
	//BoardDAO boardDAO;
	
	
	//게시글 등록메서드
	@Override
	public void register(String name, String title, String content) {	
		
		//System.out.println("----서비스계층----");
		//System.out.println(name); 
		//System.out.println(title);
		//System.out.println(content);
		
		//1st커멘드객체를이용
//		BoardVO vo = new BoardVO();
//		vo.setName(name); 
//		vo.setTitle(title);
//		vo.setContent(content);
//		mapper.insert(vo); 

		//2nd 맴타입으로 이동 
		//여러개의 값을 전달할 떄 사용한 Key값이 마이바티스 전달에 사용될 값이 된다.
		Map<String,String> map= new HashMap<>(); 
		map.put("p1", name); 
		map.put("p2", title);
		map.put("p3", content);
		
		mapper.insert(map); 		
	}

	//게시글 List보기메서드
	@Override
	public ArrayList<BoardVO> getList() {
		
		ArrayList<BoardVO> DB = mapper.select(); 
		
		return DB;
	}

	@Override
	public void delete(String num) {
		
		mapper.delete(num);
		
		
	}

}
