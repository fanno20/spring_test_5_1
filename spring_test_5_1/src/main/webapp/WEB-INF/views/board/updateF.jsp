<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
<p>NOTICE BOARD UPDATE PAGE</p>
<form action="./update" method="post">
	<input type="hidden" value="${bdDto.num}" name="num">
	<div class="form-group">
		<label for="wr">TITEL:</label>
		<input type="text" class="form-control" id="wr" value="${bdDto.title}" name="title">
	</div>
	<div class="form-group">
		<label for="contents">CONTENTS:</label>
		<textarea class="form-control" rows="5" id="contents" name="contents">${bdDto.contents}</textarea>
	</div>
	<div>
		<input type="submit" value="수정" class="btn-default">
	</div>
</form>
<a href="./list?curPage=1">글목록보기</a><br>
<a href="/p5/">HOME</a>
</body>
</html>