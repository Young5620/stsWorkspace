package com.zerock.command;

public class BoardVO {

	private int num; 
	private String name; 
	private String title; 
	private String content; 
	
	public BoardVO() { } //별 의미 없지만 오류발생방지 

	//num은 삭제, num은 자체적으로 만들지 전달받아 처리하지 않기 때문 
	public BoardVO(String name, String title, String content) {
		super();
		this.name = name;
		this.title = title;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
	
}
