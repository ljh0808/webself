<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<c:forEach var="list" items="${list}">
  no:${list.no}  
  <a href="/ListView.do?no=${list.no}" id="${list.no}">제목:${list.title}</a>
    작성자:${list.writer}  작성일:${list.day}  조회수:${list.count} <br/>
</c:forEach>
<button type="button" onclick="location.href='/listadd.jsp'">글 작성</button>
</body>
</html>