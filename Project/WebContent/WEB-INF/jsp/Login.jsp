<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"href="style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<title>ログイン画面</title>
</head>
<body>
<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>
<h1 class="title">ログイン画面</h1>
<form action="LoginServlet" method="post">
<p class="center">ログインID
<input type="text" name="id" style="margin-left:20px"><br>
</p>
<p class="center">パスワード
<input style="margin-left:20px" type="text" name="pass"><br>
<input type="submit" style="margin-top:30px" value="ログイン">
</form>
</body>
</html>