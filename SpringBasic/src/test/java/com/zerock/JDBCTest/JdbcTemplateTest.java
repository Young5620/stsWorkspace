package com.zerock.JDBCTest;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)//@RunWith-Spring Framework가 독립적으로 사용되도록 구동 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml") 
//사용할 스프링 설정파일 경로지정 (Application Context)  
public class JdbcTemplateTest {
	//Spring-test라는 라이브러리가 추가되어 있어야함. 
	//Run As-> JUnitTest(@Test 어노테이션으로 JUnit 사용이 가능) 
	
	@Autowired //Type기준 먼저호출(ds) => bean객체 이름 => 변수명
	DataSource ds;
	@Autowired
	JdbcTemplate jdbcTemplate; 
	
	@Test
	public void testTemplate () { 
		try {
			Connection conn = ds.getConnection(); 
			System.out.println(">>>>>Connection출력:"+conn);
			System.out.println(">>>>>템플릿객체생성:"+jdbcTemplate);
			
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
		
		
	}

	
	
	
}
