<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<form action="/enter/join" method="post">
아이디<input type="text" name="id" id="id" required="required"/> <button type="button">중복체크</button> <br/>
비밀번호<input type="password" name="pwd" id="pwd" required="required"/><br/>
이름 <input type="text" name="name" id="name" required="required"/><br/>
이메일<input type="email" name="email" id="email" required="required"/><br/>
<input type="submit" value="가입"/> <input type="reset" value="리셋"/>
</form>
</body>
</html>