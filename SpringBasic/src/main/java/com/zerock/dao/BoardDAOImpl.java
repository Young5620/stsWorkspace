package com.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.zerock.command.BoardVO;

public class BoardDAOImpl implements BoardDAO {

	//DB로 가정할 ArrayList 처리
	//ArrayList<BoardVO> DB = new ArrayList<>();
	
	//JDBC처리
	//1. 아티팩트 설치(ojdbc8.jar) - maven에서(pom.xml)
	//<dependency>
	//	<groupId>com.oracle.database.jdbc</groupId>
	//	<artifactId>ojdbc8</artifactId>
	//	<version>21.1.0.0</version>
	//</dependency>
	//2. DB내에 board01 테이블생성
	/*
	 create table board01(
	 	num int primary key(sequence적용),
	 	name varchar(20),
	 	title varchar(30),
	 	content varchar(50)
	 	);
	 */
	//3. DB연결정보 생성
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String user= "myjsp";
	private String password = "myjsp";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//4. 각 메소드별 처리
	
	//게시글 등록처리
	@Override
	public void boardInsert(String name, String title, String content) {
		String sql = "insert into board01 (name,title,content) values (?,?,?)";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<BoardVO> boardSelect() {
		ArrayList<BoardVO> DB = new ArrayList<>();
		String sql = "select * from board01 order by num asc";
		BoardVO vo = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				
				vo = new BoardVO(num, name, title, content);
				DB.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return DB;
	}

	@Override
	public void boardDelete(String num) {
		String sql = "delete from board where num=?";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
