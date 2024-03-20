<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
</head>
<body>
<form action="/ListAddController" id="add" name="add" method="post">
	  <p>제목<input type="text" size="30" id="title" name="title"></p>
      내용<p><textarea cols="50" rows="10" id="content" name="content"></textarea></p>
      <p><input type="submit" value="작성하기"></p>
    
</form>
</body>
</html>