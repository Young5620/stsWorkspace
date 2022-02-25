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
    <h1 class="page-header">Board Register</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header bg-primary text-white">게시글 등록</div>
      <div class="card-body">



        <form role="form" action="register" method="post" id="regform">
          <div class="form-group">
            <label>제목</label>
            <input class="form-control" name="title" id="title">
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name="content" id="content"></textarea>
          </div>

          <div class="form-group">
            <label>작성자</label>
            <input class="form-control" name="writer" id="writer">
          </div>
          <button type="submit" class="btn btn-primary">등록</button>
          <button type="button" class="btn btn-primary">취소</button>
        </form>
<!-- 
등록 클릭시 title, content, writer값을 검증 처리하는 스크립트
취소시 cri.pageNum과 cri.count값을 전달하여 처리하기
$("#아이디") HTML 속성에 한번에 접근...val() => 해당 아이디의 값에 접근하는 함수
 -->


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