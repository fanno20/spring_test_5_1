<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:if test="${member eq null}">
	<a href="./member/joinF.me">회원가입</a><br>
	<a href="./member/loginF.me">LOGIN</a><br>
</c:if>
<c:if test="${member ne null}">
	<script type="text/javascript">
		alert('${result}');
	</script>
	<h2>${member.name}님 접속</h2>
	<a href="./member/updateF.me">정보수정</a><br>
	<a href="./member/logout.me">LOGOUT</a><br>
	<a href="./member/delete.me">회원탈퇴</a><br>
</c:if>
<a href="./board/list?curPage=1&perPage=10">글목록보기</a><br>
</body>
</html>
