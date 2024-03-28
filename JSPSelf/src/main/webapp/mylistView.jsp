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
<c:forEach var="list" items="${list}">
  no:${list.no}  
제목:${list.title}
    작성자:${list.writer}  작성일:${list.day}  조회수:${list.count} <br/>
    내용 :${list.content}<br/>
    <table>
<a href="/listupdate.jsp?no=${list.no}" id="${list.no}"><button>수정</button></a>
<form action="/ListDelete.do" method="post">
<input type="submit" name="delete" id="delete" value="삭제"/>
<input type="hidden" id="num" name="num" value="${list.no}"/>
</form>
</c:forEach>
<button type="button" onclick="location.href='/list.do'">글목록</button>
</table>
</body>
</html>