<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입(화면URL요청:컨패스/service/member_tx01)</h2>
	
<!-- 
1. join의 맵핑을 처리할 수 있는 매서드를 생성(Controller로 정보는id, pw, name 최소로)
2. command 패키지 parameter값을 처리할 수 있는 커맨드 객체 JoinVO 값을 받아 처리한다. 
(멤버는 id, pw, name최소로..) 
3. service패키지 JoinService인터페이스와, JoinService를 구현하는 JoinServiceImpl클래스를 
생성 
4. JoinServiceImpl을 Annotation을 이용하여 자동객체 생성시키세요 @Service(이름) 
5. 컨트롤러의 멤버변수로 해당객체를 자동의존성 주입 (Autowired) 
 -->
	
	
	
	<form action="join" method="post"> 
	ID:<input type="text" name="id" size="10"> <br> 
	PW:<input type="password" name="pw" size="10"> <br>
	NAME:<input type="text" name="name" size="10"> <br> 
	<input type="submit" value="회원가입">  
	</form>
	

</body>
</html>