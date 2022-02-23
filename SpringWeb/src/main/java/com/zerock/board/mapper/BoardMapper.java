package com.zerock.board.mapper;

import java.util.ArrayList;

import com.zerock.board.command.BoardVO;

public interface BoardMapper {
	
	public ArrayList<BoardVO> getList(); //모든 게시물 가져오기
	public void insertBoard(BoardVO vo); //게시물 등록
	public BoardVO getContent(int num);  //게시물 상세보기
	public boolean updateBoard(BoardVO vo); //게시물 수정 완료버튼 클릭시
	public void deleteBoard(int num); //게시물 삭제
}
