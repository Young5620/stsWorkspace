package com.zerock.service;

import java.util.ArrayList;

import com.zerock.command.BoardVO;

public interface BoardService {

	//board 등록 메서드
	public void register(String name, String title, String content);
	//모든 게시물 가져오기
	public ArrayList<BoardVO> getList();
	//게시글 삭제 메서드
	public void delete(String num);
	
}
