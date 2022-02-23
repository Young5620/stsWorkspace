package com.zerock.database;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//테스트를 위한 준비
//pom.xml의 Junit 버전을 4.12로 변경. spring-test 라이브러리가 다운되어 있어야함

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisTest {
	@Autowired
	private SqlSessionFactoryBean session;
	//=private SqlSessionFactory session;
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testFactory() {
		try {
			System.out.println("주입성공? " + session);
			System.out.println("------------------");
			System.out.println("주입성공?" + dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
