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
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#writeBtn").click(function(){
			location.href = "./writeF";
		});
	})
</script>
</head>
<body>

<select name="perPae">
	<option value="20">20개씩 보기</option>
	<option value="30">30개씩 보기</option>
	<option value="40">40개씩 보기</option>
</select>

<div class="d1">
	<p>NOTICE BOARD LIST PAGE</p>
	<table class="table">
		<tr><td>num</td><td>title</td><td>writer</td><td>reg_date</td></tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td><a href="./view?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.writer}</td>
				<td>${dto.reg_date}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<%-- <c:if test="${page['curBlock'] > 1}">
			<a href="./list?curPage=${page['start']-1}">이전</a>
		</c:if>
		<c:forEach begin="${page['start']}" end="${page['last']}" var="i">
			<a href="./list?curPage=${i}">${i}</a>
		</c:forEach>
		<c:if test="${page['curBlock'] < page['totalBlock']}">
			<a href="./list?curPage=${page['last']+1}">이후</a>
		</c:if> --%>
		<c:if test="${boardPageing.curBlock > 1}">
			<a href="./list?curPage=${boardPageing.startNum-1}">[이전]</a>
		</c:if>
		<c:forEach begin="${boardPageing.startNum}" end="${boardPageing.lastNum}" var="i">
			<a href="./list?curPage=${i}">${i}</a>
		</c:forEach>
		<c:if test="${boardPageing.curBlock < boardPageing.totalBlock}">
			<a href="./list?curPage=${boardPageing.lastNum+1}">[다음]</a>
		</c:if>
		<c:if test="${member ne null}">
			<input type="button" value="글쓰기" class="btn-default" id="writeBtn">
		</c:if>
	</div>
	<a href="/p5/">HOME</a>
</div>



</body>
</html>







