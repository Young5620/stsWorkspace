<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보 처리</h2>
	<h3>전통적인 방법</h3>
	<form action="/service/memlogin" method="post">
		ID : <input type="text" name="memId"><br>
		PW : <input type="password" name="memPw"><br>
		<input type="submit" value="login">
	</form>
	<hr>
	<h3>어노테이션을 이용한 방법</h3>
	<form action="/service/memlogin2" method="post">
		ID : <input type="text" name="memId"><br>
		PW : <input type="password" name="memPw"><br>
		<input type="submit" value="login">
	</form>
	<hr>
	<h3>커맨드을 이용한 방법</h3>
	<form action="/service/memlogin3" method="post">
		ID : <input type="text" name="id"><br>
		PW : <input type="password" name="pw"><br>
		Name : <input type="text" name="name"><br>
		<input type="submit" value="login">
	</form>
</body>
</html>