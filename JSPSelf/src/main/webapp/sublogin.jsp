<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>sub 로그인페이지</h2><br/>
${msg} <br/>

<form action="/enter/main" method="post">
아이디: <input type="text" id="id" name="id"/>
비밀번호: <input type="password" id="pwd" name="pwd"/>
<input type="submit" id="enter" name="enter" value="접속"/>
<button type="button" onclick="location.href='/join.jsp'">회원가입</button>
</form>
</body>
</html>