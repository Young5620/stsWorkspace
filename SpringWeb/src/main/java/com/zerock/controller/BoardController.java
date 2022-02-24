package com.zerock.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.board.command.BoardVO;
import com.zerock.board.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	//1. Controller 구현(뷰작업)
	//2. 테이블 생성(더미 데이터 작업)
	/*
	 	create table tbl_board(
    	num int default tbl_board_seq.nextval primary key,
    	title varchar(200) not null,
    	content varchar(2000) not null,
    	writer varchar(50) not null,
    	regdate timestamp default sysdate,
    	updatedate timestamp default sysdate
		);
	 */
	//3. DB관련 설정테스트(root-context.xml 작업 후 테스트)
	//4. BoardVO 생성(DB의 컬럼명으로 동일하게 생성)
	//5. Service 구현
	//6. DAO 구현
	
	@Autowired
	private BoardService service;
	
	
	//get방식
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() {
		System.out.println("등록화면처리");
		return "board/register";
	}
	
	//post방식
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(BoardVO vo) {
		System.out.println("등록처리");
		//서비스처리..
		service.register(vo);
		return "redirect:/board/list";
	}
	
	//게시글 리스트
	@RequestMapping("/list")
	public String list(Model model) {
		//list에 요청이 들어오면 db에서 모든값을 가지고 화면으로 이동해야한다.
		ArrayList<BoardVO> list = service.getList();
		//컨트롤러 메서드의 리턴값ㅇ르 추가하고 싶다면..
		//1. model객체를 추가
		//2. 리턴 유형을 ModelAndView객체를 추가
		model.addAttribute("boardlist",list);
		
		return "board/list";
	}
	
	//게시글 내용보기
	@RequestMapping("/content")
	public String content(@RequestParam("num") int num, Model model) {
		System.out.println("======controller계층======");
		System.out.println(num);
		BoardVO vo = service.getContent(num);
		model.addAttribute("board", vo);
		return "board/content";
	}
	
	//게시글 수정 화면으로 가기
	@RequestMapping("/modify")
	public String modify(@RequestParam("num") int num, Model model) {
		BoardVO vo = service.getContent(num);
		model.addAttribute("board", vo);
		return "board/modify";
	}
	
	//게시글 수정 완료 처리
	@RequestMapping("/update")
	public String update(BoardVO vo) {
		System.out.println("=====컨트롤 계층=====");
		System.out.println(vo.getNum());
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		
		//문제
		//1. service 계층에 전달받은 폼값은 전달하는 update(vo)를 생성
		//2. update()메서드 안에서 mybatis로 연결하는 BoardUpdate(vo) 메서드를 새성
		//3. 동작하여 업데이트 진행~
		service.update(vo);
		
		return "redirect:/board/list";
	}
	
}
