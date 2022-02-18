package com.zerock.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.command.ScoreVO;
import com.zerock.service.ScoreService;
import com.zerock.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service/*")
public class ScoreServiceController {
	
	//1번째 방법 - 객체 생성
	//ScoreService scoreService = new ScoreServiceImpl();
	
	//2번째 방법 - 설정에 bean등록 후에 ScoreService scoreService 주입설정
	//@Resource(name="scoreService")
	//ScoreService scoreService;
	
	//3번째 방법 - 어노테이션을 이용한 빈생성 및 자동주입 설정(@Service로 주입)
	@Autowired
	ScoreService scoreService; //service패키지에 컴포넌트 스캔 걸어야함...
	
	//화면처리 - 점수등록 화면으로 처리
	@RequestMapping("/1scoreRegister")
	public String score() {
		return "service/1scoreRegister";
	}
	
	//점수 등록 메서드
	@RequestMapping("scoreForm")
	public String scoreForm(ScoreVO vo) {
		scoreService.scoreRegist(vo); //점수 등록 진행
		return "service/2scoreResult"; //뷰리졸버를 통해서 강제이동
	}
	
	//화면처리 - 점수목록
	@RequestMapping("/3scoreList")
	public String scoreList(Model model) {
		//결과반환 메서드 불러오기
		//메서드의 파리미터에 Model을 추가하여, model에 list를 실어줌(화면에서 사용 가능하게)
		ArrayList<ScoreVO> scoreList =  scoreService.scoreResult();
		
		model.addAttribute("scoreList", scoreList);
		
		return "service/3scoreList";
	}
	
	//삭제 메서드
	@RequestMapping("/scoreDelete")
	public String scoreDelete(@RequestParam("num") String num) {
		
		//점수 삭제 메서드
		scoreService.scoreDelete(num);
		//return "service/3scoreList"; 를 사용하면 list값을 가져갈 수 없음
		return "redirect:/service/3scoreList"; //*** 다시 컨트롤러를 탈 수 있게 강제이동
	}
}
