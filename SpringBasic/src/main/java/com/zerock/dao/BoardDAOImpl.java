package com.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zerock.command.BoardVO;


@Repository
public class BoardDAOImpl implements BoardDAO {

	//DB로 가정할 ArrayList처리,DB자체를 만드는 것으로 가정
	//ArrayList<BoardVO> DB= new ArrayList<>(); 
	
	//JDBC처리  
	//1. 아티팩트 설치(ojdbc8.jar)-maven 에서...(pom.xml) 
	//2. DB내에 board01테이블 생성
	/*
	create table board1 (	
	NUM INT DEFAULT BOARD_NUM.nextval PRIMARY KEY, 
	NAME VARCHAR(20), 
	TITLE VARCHAR(30),
	CONTENT VARCHAR(50) 
	); */

	
	/*
	 빈 설정 없는 경우(root-context.xml에 설정하지 않은 경우) 
	 private HikariConfig hikariConfig;  
	 private HikariDataSource dataSource; 
	 private JdbcTemplate jdbcTemplate; 
	 
	 public BoardDAOImpl() { 
	 	hikariConfig = new HikariConfig(); //객체생성(bean생성)  
	 	hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver"); //세터설정 
	 	hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1"); //세터설정 
	 	hikariConfig.setUsername("myjsp"); 
	 	hikariConfig.setPassword("myjsp"); 
	 	
	 	dataSource= new HikariDataSource(hikariConfig);//datasource객체생성 
	 	jdbcTemplate= new JdbcTemplate(); 
	 	jdbcTemplate.setdataSource(dataSource);
	 } 
	 
	 
	 */
//	
//	// 3. DB 연결정보 생성 
//	private String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";
//	private String user="myjsp";
//	private String password="myjsp";
//	
//	// 4. 각 메소드별 처리
//	private Connection conn= null;
//	private PreparedStatement pstmt=null; 
//	private ResultSet rs= null; 
//	
//	//게시글 등록처리
//	@Override
//	public void boardInsert(String name, String title, String content) {
//
//		String sql="INSERT INTO BOARD01(name,title,content) values (?,?,?)";
//		try {
//			/*System.out.println("----DAO계층----");
//			System.out.println(name);
//			System.out.println(title);
//			System.out.println(content);
//			*/
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn= DriverManager.getConnection(url,user,password); 
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name );
//			pstmt.setString(2, title);
//			pstmt.setString(3, content);
//			pstmt.executeUpdate(); 
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {  
//			try {
//				if (conn!=null) conn.close(); 
//				if (pstmt!=null) pstmt.close(); 
//				if (rs!=null) rs.close(); 
//				
//			}catch(Exception e2) { 
//				
//			} 
//			
//		}
//	/*
//		BoardVO vo = new BoardVO(); 
//		vo.setName(name);
//		vo.setTitle(title);
//		vo.setContent(content);
//		
//		DB.add(vo);
//		System.out.println("현재 게시물 수: "+ DB.size());
//	*/
//	}
//	
//	
//	@Override
//	public ArrayList<BoardVO> boardSelect() {
//		
//		ArrayList<BoardVO> list= new ArrayList<BoardVO>(); 
//
//		String sql="SELECT * FROM BOARD01 ORDER BY NUM ASC";
//		
//		try {	
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn= DriverManager.getConnection(url,user,password); 
//			pstmt = conn.prepareStatement(sql);
//			rs= pstmt.executeQuery(); 
//			
//			while(rs.next()) {
//			int num= rs.getInt("num");
//			String name =rs.getString("name");	
//			String title= rs.getString("title");
//			String content= rs.getString("content"); 
//			
//			BoardVO vo= new BoardVO(); 
//			vo.setNum(num);
//			vo.setName(name);
//			vo.setTitle(title);
//			vo.setContent(content);
//			
//			list.add(vo);
//			
//			} 
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {  
//			try {
//				if (conn!=null) conn.close(); 
//				if (pstmt!=null) pstmt.close(); 
//				if (rs!=null) rs.close(); 
//				
//			}catch(Exception e2) { 
//			} 	
//		}
//		return list; 
//	}
//
//	@Override
//	public void boardDelete(String num) {
//		
//		String sql="DELETE FROM BOARD01 WHERE NUM=?";
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn= DriverManager.getConnection(url,user,password); 
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, num );
//			pstmt.executeUpdate(); 
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {  
//			try {
//				if (conn!=null) conn.close(); 
//				if (pstmt!=null) pstmt.close(); 
//				if (rs!=null) rs.close(); 
//				
//			}catch(Exception e2) { 
//				
//			} 
//			
//		}
//
//}
	
//	 private HikariConfig hikariConfig;  
//	 private HikariDataSource dataSource; 
//	 private JdbcTemplate jdbcTemplate; 
//	 
//	 public BoardDAOImpl() { 
//	 	hikariConfig = new HikariConfig(); //객체생성(bean생성)  
//	 	hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver"); //세터설정 
//	 	hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1"); //세터설정 
//	 	hikariConfig.setUsername("myjsp"); 
//	 	hikariConfig.setPassword("myjsp"); 
//	 	
//	 	dataSource= new HikariDataSource(hikariConfig);//datasource객체생성 
//	 	jdbcTemplate= new JdbcTemplate(); 
//	 	jdbcTemplate.setDataSource(dataSource);
//	 } 
//	
	
	/*
<root-context로 불러지는 bean> 
	HikariConfig <- HikariDataSource <- JdbcTemplate

<servlet-context에 의해 불러와지는 bean>

@Controller로 => (Bean객체)BoardServiceController 등록 
	: Controller는 Service와 View 사이에 존재
 	@Autowired <- @Service(BoardServiceImpl(BoardService-[i]))

@Service => BoardServiceImpl(BoardService-[i])
	:DAO를 불러서 사용하는 존재 
	@Autowired <- @DAO( BoardDAOImpl(BoardDAO-[i])) 

@DAO     => BoardDAOImpl(BoardDAO-[i]) 
	:DB 작업용 
	@Autowired <- JdbcTemplate(root-context 정의된)
 
	 
	 
	 
	 
	 
	 * */
	
	//root-context.xml에서 설정 후 주입.
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	private DataSource dataSource; 
	
	

	@Override
	public void boardInsert(String name, String title, String content) {
		System.out.println(dataSource);
		System.out.println(jdbcTemplate); //검증처리
		String sql="INSERT INTO BOARD01(name,title,content) values(?,?,?)";
		
		//1st방법
//		int result = jdbcTemplate.update(sql,new PreparedStatementSetter() {  
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException{  
//				ps.setString(1, name); 
//				ps.setString(2, title); 
//				ps.setString(3, content);
//			}	
//			}); 
//		System.out.println("결과조회(성공:1,실패:0):"+result);
//		
		//2nd방법
		//update()메서드의 파라미터 값으로(sql문,?에 바인딩할 값) 
		int result= jdbcTemplate.update(sql, new Object[] {name,title,content});
		System.out.println(result);
		
	}
	
	
	@Override
	public ArrayList<BoardVO> boardSelect() {
		/*
		 query()의 파라미터 의미 
		 - sql: sql쿼리,?를 사용하는 PreparedStstement용 쿼리를 사용
		 - new Object[]{값1, 값2}: sql 물음표에 셋팅할 값을 저장 (바인딩 
		 - new RowMapper<Type>(): 조회결과를 ResultSet으로부터 데이터를 읽어와서 type데이터를 생성
		 	-> 익명클래스로 사용합니다.  
		 	-> mapRow() 메서드는 ResultSet 에서 읽어온 값을 처리한 후 리턴한다. 
		 	
		 	<root-context로 불러지는 bean> 
HikariConfig <- HikariDataSource <- JdbcTemplate

<servlet-context에 의해 불러와지는 bean>

@Controller로 => (Bean객체)BoardServiceController 등록 
	: Controller는 Service와 View 사이에 존재
 	@Autowired <- @Service(BoardServiceImpl(BoardService-[i]))

@Service => BoardServiceImpl(BoardService-[i])
	:DAO를 불러서 사용하는 존재 
	@Autowired <- @DAO( BoardDAOImpl(BoardDAO-[i])) 

@DAO     => BoardDAOImpl(BoardDAO-[i]) 
	:DB 작업용 
	@Autowired <- JdbcTemplate(root-context 정의된)
 


		 */
		String sql="select * from board01";
		//RowMapper=> ResultSet을 받아서 처리하는 역할
		List<BoardVO> list= jdbcTemplate.query(sql, new Object[] {}, new RowMapper<BoardVO>() {
	
		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {  
			
			BoardVO vo = new BoardVO();
			vo.setNum(rs.getInt("num"));
			vo.setName(rs.getString("name"));
			vo.setTitle(rs.getString("title"));
			vo.setContent(rs.getString("content"));
			return vo;
		}
		
		});	
		
		return (ArrayList<BoardVO>) list; 
		
	}
	
	@Override
	public void boardDelete(String num) { 
		String sql="DELETE FROM BOARD01 WHERE NUM=?";
		
		int result= jdbcTemplate.update(sql, new Object[] {num});
		System.out.println(result);
		
		
	}
	
	
	

		
	}
