<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
	<h2>회원가입(화면 URL요청 : 컨패스/service/member_tx01)</h2>
	
	<section>
	  <form action="join" method="post">
	    <div align="center">
	      <table>
	        <tr>
	          <td>ID</td>
	          <td><input type="text" name="id"></td>
	        </tr>
	        <tr>
	          <td>PW</td>
	          <td><input type="password" name="pw"></td>
	        </tr>
	        <tr>
	          <td>Name</td>
	          <td><input type="text" name="name"></td>
	        </tr>
	        <tr>
	          <td colspan="2" align="center"><input type="submit" value="회원가입"></td>
	        </tr>
	      </table>
	    </div>
	  </form>
	</section>
	
  </body>
</html>