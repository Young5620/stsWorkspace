<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>전통적방법</h2>
<form action="/service/memlogin" method="post">
	ID: <input type="text" name="memid"> <br>  
	PW: <input type="password" name="mempw"> <br>  
	<input type="submit" value="login"> 
</form>

<hr>

<h2>어노테이션 이용한 방법</h2>
<form action="/service/memlogin2" method="post">
	ID: <input type="text" name="memid"> <br>  
	PW: <input type="password" name="mempw"> <br>  
	<input type="submit" value="login"> 
</form>

<hr>  

<h2>커멘드를 이용한 방식(MemberVO를 이용한 처리)</h2>
<form action="/service/memlogin3" method="post">
	ID: <input type="text" name="id"> <br>  
	PW: <input type="password" name="pw"> <br>
	NAME: <input type="text" name="name"> <br>
	<input type="submit" value="login"> 
</form>




</body>
</html>