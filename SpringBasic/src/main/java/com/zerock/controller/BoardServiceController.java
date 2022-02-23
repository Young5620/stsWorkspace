package com.zerock.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.command.BoardVO;
import com.zerock.service.BoardService;
import com.zerock.service.BoardServiceImpl;

@Controller
@RequestMapping("/service/*")
public class BoardServiceController {

	@Autowired  
	BoardService boardService;
	
	//화면처리-게시판등록  
	@RequestMapping("/boardRegister")
	public String boardRegister() {
		
		return "service/boardRegister"; 
	} 
	
	//게시글등록요청처리 
	@RequestMapping("/boardForm")
	public String boardForm(
			@RequestParam("name") String name,
			@RequestParam("title") String title,
			@RequestParam("content") String content
			) { 
		
		boardService.register(name, title, content); //보드서비스의 register메서드로 전달하기! 
		
		return "service/boardResult"; 
	} 
	
	//게시글 리스트보기 요청처리
	@RequestMapping("/boardList") 
	public String boardList(Model model) { 
		
		ArrayList<BoardVO> DB = boardService.getList(); 
		
		//전달받은 DB를 boardList이름으로 전달 
		model.addAttribute("boardList",DB); 
		
		return "service/boardList";
	} 
	
	//게시글 삭제처리
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("num") String num) {
		
		//점수 삭제 메서드
		boardService.delete(num);
		
		//return "service/3scoreList"; //이렇게 화면으로 넘겨주면 list값을 가져갈 수 없음. 
		return "redirect:/service/boardList";  //***다시 컨트롤러를 탈 수 있게 강제 이동... 
	}

	
	
	
	
	
	
	
}
