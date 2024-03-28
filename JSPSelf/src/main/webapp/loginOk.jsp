<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인성공 페이지</title>
</head>
<body>
<%=session.getId() %>
<h3>${id}님 환영합니다</h3>
<button type="button" onclick="location.href='list.do'">게시판</button>
<button type="button" onclick="location.href='/logout.do'">로그아웃</button>
<button type="button">회원정보</button>
</body>
</html>