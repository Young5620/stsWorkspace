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
    <h1 class="page-header">Board Modify Page</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header bg-primary text-white">수정 페이지</div>
      <div class="card-body">



        <form role="form" action="update" method="post" name="regform" id="regform">
          
          <div class="form-group">
            <label>번호</label>
            <input class="form-control" name="num" value="${board.num }" readonly>
          </div>
          
          <div class="form-group">
            <label>제목</label>
            <input class="form-control" name="title" value="${board.title }">
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name="content">${board.content }</textarea>
          </div>

          <div class="form-group">
            <label>작성자</label>
            <input class="form-control" name="writer" value="${board.writer }" readonly>
          </div>
          
          
           
          <button type="submit" class="btn btn-primary">변경</button>
          <button type="button" class="btn btn-secondary" onclick="location.href='delete?num=${board.num}'">삭제</button>          
          <button type="button" class="btn btn-dark" onclick="location.href='list?pageNum=${cri.pageNum}&count=${cri.count }'">목록</button>

<!-- 
 		  <button type="button" class="btn btn-primary" onclick="check('modify')"> 변경</button>
          <button type="button" class="btn btn-secondary" onclick="check('delete')">삭제</button>          
          <button type="button" class="btn btn-dark" onclick="check('list')">목록</button>
  -->
        </form>



      </div>
      <!--  end card-body -->
    </div>
    <!--  end card-body -->
  </div>
  <!-- end card -->
</div>
<!-- /.row -->

<%@ include file="../include/footer.jsp" %>
<script>
if(document.regform.title.value == '') {
	alert("제목을 입력하세요");
	return;
} else if(document.regform.content.value == '') {
	alert("내용을 입력하세요");
	return;
} else if(confirm("변경하시겠습니까?")) {
	document.regform.submit();
}
</script>
<!-- 
$("#아이디") 는 HTML의 아이디 속성에 한번에 접근할 수 있음
attr
<script>
function check(e) {
	if(e=='modify') {
		if(document.regform.title.value == '') {
			alert("제목을 입력하세요");
			return;
		} else if(document.regform.content.value == '') {
			alert("내용을 입력하세요");
			return;
		} else if(confirm("변경하시겠습니까?")) {
			document.regform.submit();
		}
	} else if(e == 'delete') {
		if(confirm("삭제하시겠습니까?")) {
			$("#regform").attr("action","delete");
			$("#regform").submit();
		} else {
			return;
		}
	} else {
		$("#regform").attr("action","list");
		$("#regform").submit();
	}
}
</script> -->
</body>
</html>