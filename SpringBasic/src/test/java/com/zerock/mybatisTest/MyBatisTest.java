package com.zerock.mybatisTest;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//주로 개발과정에서 DB연결에서 주로 Test함
//src/test/java폴더에는 자바 클래스를 이용하여 여러 작업을 테스트할 용도로 사용됨. 
//실행은 Run as => JUnitTest를 사용하여 실행 
//@Test Annotation을 사용하여 테스트할 메서드를 지정  

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisTest {

	//root-context.xml에 SqlSessionFactory 빈 추가를 확인 
	
	@Autowired
	SqlSessionFactory sqlFactory; 
	
	@Test
	public void testFactory() { 
		System.out.println(">>>>>>>>>>>>>>>>>>>>sqlFactory출력:"+sqlFactory);
		
	} 
	
	
	
	
}
