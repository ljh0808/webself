<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<form action="/enter/join">
아이디<input type="text" name="id" id="id"/><br/>
비밀번호<input type="password" name="pwd" id="pwd"/><br/>
이름 <input type="text" name="name" id="name"/><br/>
이메일<input type="text" name="email" id="email"/><br/>
<input type="submit" value="가입"/>
</form>
</body>
</html>