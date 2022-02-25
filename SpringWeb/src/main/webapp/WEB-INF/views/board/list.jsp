<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	
<!DOCTYPE html>
<html lang="ko">

<head>

</head>

<body id="page-top">
	<!-- Page Wrapper -->

	<%@include file="../include/header.jsp"%>

	<!-- Begin Page Content -->
	

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">게시판</h1>


		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">공지사항 샘플 게시판
                    <button type="button" class="btn btn-primary btn-sm float-right" onclick="location.href='register'">글쓰기</button>
                </h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>수정일</th>
								
							</tr>
						</thead>
						<c:forEach var="good" items="${boardlist}">
						<tbody>	
							<tr>
								<td>${good.num }</td>
								<!-- 상세페이지 이동 -->
								<td>
								<!-- 7.조회페이지 이동 -->
								<!-- 
								-상세페이지 이동 후 목록 화면으로 이동할 떄, 기존 페이질르 유지하지 못하는 문제가 있다. 
								-상세, 수정화면 등으로 이동할때 항상 pageNum과 count를 가지고 다녀야 한다. 
								-변경했다면, content 요청에서 변경한다. 
								 -->
								<a href="content?num=${good.num}&pageNum=${pageMaker.cri.pageNum}&count=${pageMaker.cri.count}">
								
								${good.title }
								</a>
								
							<!-- <a href="content?num=${good.num}">${good.title } </a> -->
							
							</td>
								<td>${good.writer }</td>
								<td>
									<fmt:formatDate value="${good.regdate }" pattern="yyyy-MM-dd hh:mm:ss"/>
								</td>
								<td>
									<fmt:formatDate value="${good.updatedate }" pattern="yyyy-MM-dd"/>
								</td>
							</tr>
						</tbody>
						</c:forEach>
						
					</table>
					<!-- 페이징 처리 부분 부트스트랩 참고 -->
					<ul class="pagination justify-content-center">
                       	 
						<!--1. 이전페이지 활성화 여부 -->
						<c:if test="${pageMaker.prev }">                        	 
                       	 <li class="page-item">
                       	 	<!-- 6.이전 버튼 활성화 링크 -->
                       	 	<!-- 시작페이지는 startPage가 11일떄 활성화됩니다 -->
                       	 	<!-- 이전 페이지를 클릭했을 때, startPage가 11일떄 활성화 
                       	 	이전페이지를 클릭했을때, startPage-1 = 10을 pageNum 으로 전달
                       	 	getPageStart()를 통해 마이바티스 값이 전달... 
                       	 	
                       	 	 -->
							<a class="page-link" href="list?pageNum=${pageMaker.startPage }">Previous</a>
						</li>
					   </c:if> 
					   
					   <!-- 2. 페이지 번호 활성화 여부 -->
					  <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
					  	<!-- 4.1 ##active 속성을 이용하여 활성화 버튼을 연결 -->
					  	<li class="page-item ${pageMaker.cri.pageNum ==num?'active':''}">
									  	
					    <!-- 4.list요청으로 페이지 번호를 전달, 자동으로 count=10(보여질 페이지 수) -->
					    <!-- 사용자가 버튼을 클릭시에 해당 버튼에 해당하는 페이지 번호를 Criteria에 매핑 -->
					    
					    	<a class="page-link" href="list?pageNum=${num}">${num}</a>
					    </li>
					   </c:forEach>
					   
					   <!-- 3. 다음 페이지 활성화 여부 -->
						<c:if test="${pageMaker.next}"> 			   
					    <li class="page-item">
					    <!-- 5. Next 버튼 활성화 링크 -->
					    <!-- pageMaker의 endPage는 화면에 보여지는 끝번호 10이 들어있기 때문에
					    1증가한 값인 11은 pageNum(페이지변수)에 전달합니다
					    11이 Criteria클래스에 pageNum(setter)에 전달되고,
					    getPageStart()를 통해서 마이바티스 쿼리에 전달
					     -->
					      <a class="page-link" href="list?pageNum=${pageMaker.endPage+1}">Next</a>
					    </li>
				   		</c:if>
				    
				    </ul>
					<!-- 페이징 처리 끝 -->
				</div>
			</div>
		</div>
	<!-- End of Main -->

	<%@ include file="../include/footer.jsp"%>
</body>

</html>
