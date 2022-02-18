<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 다음 화면과 같은 내용으로 처리되도록 만드세요. -->
	<h2>게시글 목록</h2>
	
	<table>
	<tr>
	<th>번호</th>
	<th>작성자</th>
	<th>제목</th>
	<th>비고</th>
	</tr>
	
	<c:forEach var="hungry" items="${boardList }" varStatus="num">
	<tr>
	<td>${hungry.num}</td>
	<td>${hungry.name}</td>
	<td><a href="#">${hungry.title}</a></td>
	<td><input type="button" value="삭제" onclick="location.href='boardDelete?num=${hungry.num}'">
	</c:forEach>
	
	<!-- 
	1.게시물 보여주기 완료 후에 삭제처리(boardDelete)를 만드세요
	2.삭제 후에는 목록 화면으로 리다이렉트 하세요
	 -->
	 <!-- 게시글 작성페이지로 이동 -->	
	</table>
	<a href="boardRegister">게시글 작성</a>
</body>
</html>