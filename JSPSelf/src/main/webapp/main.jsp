<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈페이지</title>
</head>
<body>

<form action="/enter/main" method="post">
아이디: <input type="text" id="id" name="id"/>
비밀번호: <input type="password" id="pwd" name="pwd"/>
<input type="submit" id="enter" name="enter" value="접속"/>
<button type="button" onclick="location.href='join.jsp'">회원가입</button>
<button type="button" onclick="location.href='/ListController'">게시판</button>
</form>
</body>
</html>