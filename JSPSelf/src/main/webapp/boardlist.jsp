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
<table border="1">
<c:forEach var="list" items="${list}">
<tr>
 <th> no:${list.no}</th>  
  <td><a href="/ListView.do?no=${list.no}" id="${list.no}">제목:${list.title}</a></td>
    <td>작성자:${list.writer}</td>  <td>작성일:${list.day}</td>  <td>조회수:${list.count} </td> </tr><br/>
</c:forEach>
</table>
<button type="button" onclick="location.href='/listadd.jsp'">글 작성</button>
<button type="button" onclick="location.href='/loginOk.jsp'">메인페이지</button>
</body>
</html>