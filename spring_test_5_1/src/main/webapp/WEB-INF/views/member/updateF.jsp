<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>UPDATE FORM PAGE</p>
<form action="update.me" method="post">
	ID : <input type="text" name="id" value="${member.id}" readonly="readonly"><br>
	PW : <input type="password" name="pw"><br>
	NAME : <input type="text" name="name"><br>
	<input type="submit" value="정보수정"><br>
</form>
<a href="/p5/">HOME</a>
</body>
</html>