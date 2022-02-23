package com.zerock.service;

import java.util.ArrayList;

import com.zerock.command.BoardVO;

public interface BoardService {

	//board등록메시지 메서드
	public void register(String name,String title, String content); 
	
	//모든게시물 가져오기 메서드
	public ArrayList<BoardVO> getList(); 
	
	//게시글 삭제 메서드
	public void delete(String num); 
	
}
