<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<style type="text/css">
	body{
		width: 100%;
	}
	.d1{
		width: 60%;
		margin: 0 auto;
	}
	table{
		width: 100%;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#deleteBtn").click(function(){
			location.href = "./delete?num=${bdDto.num}";
		});
		$("#updateBtn").click(function(){
			location.href = "./updateF?num=${bdDto.num}";
		});
	})
</script>
</head>
<body>
<div class="d1">
	<p>NOTICE BOARD VIEW PAGE</p>
	<table class="table-bordered">
		<tr><td>num</td><td>${bdDto.num}</td><td>writer</td><td>${bdDto.writer}</td><td>reg_date</td><td>${bdDto.reg_date}</td></tr>
		<tr>
			<td>title</td><td colspan="5">${bdDto.title}</td>
		</tr>
		<tr>
			<td>contents</td><td colspan="5">${bdDto.contents}</td>
		</tr>
	</table>
	<div>
		<c:if test="${member.id eq bdDto.writer}">
			<input type="button" value="삭제" class="btn-danger" id="deleteBtn">
			<input type="button" value="수정" class="btn-default" id="updateBtn">
		</c:if>
	</div>
	<a href="./list?curPage=1">글목록보기</a><br>
	<a href="/p5/">HOME</a>
</div>
</body>
</html>