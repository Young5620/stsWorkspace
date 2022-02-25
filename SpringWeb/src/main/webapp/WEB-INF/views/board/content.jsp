<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Read Page</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header bg-primary text-white">상세보기</div>
      <div class="card-body">

          <div class="form-group">
            <label>번호</label>
            <input class="form-control" name="num" value="${board.num}" readonly="readonly"><!-- 읽기만 가능 readonly속성 -->
          </div>
          
          <div class="form-group">
            <label>제목</label>
            <input class="form-control" name="title" value="${board.title }" readonly="readonly">
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" name="content" rows="5" readonly="readonly">${board.content }</textarea>
          </div>

          <div class="form-group">
            <label>작성자</label>
            <input class="form-control" name="writer" value="${board.writer }" readonly="readonly">
          </div>
          
          <!-- 페이징 -->
          <!-- 9. 취소버튼에 pageNum, count를 가지고 이동하도록 처리 -->
          <!-- 10. 변경버튼에 pageNum, count를 가지ㄷ고 이동하도록 처리 -->
          <!-- 11. 변경후 Controller에 modify 요청에 대한 처리를 확인 -->
          <button type="button" class="btn btn-primary" onclick="location.href='modify?num=${board.num}&pageNum=${cri.pageNum}&count=${cri.count }'">변경</button>
          <button type="button" class="btn btn-dark" onclick="location.href='list?pageNum=${cri.pageNum}&count=${cri.count }'">목록</button> 
          

      </div>
      <!--  end card-body -->
    </div>
    <!--  end card-body -->
  </div>
  <!-- end card -->
</div>
<!-- /.row -->

<%@ include file="../include/footer.jsp" %>
</body>
</html>