<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<c:forEach var="list" items="${list}">
  no:${list.no}  
<th>제목:${list.title}
    작성자:${list.writer}  작성일:${list.day}  조회수:${list.count} <br/>
    내용 :${list.content}</th>
</c:forEach>

</table>
<button type="button" onclick="location.href='/list.do'">글목록</button>
</html>