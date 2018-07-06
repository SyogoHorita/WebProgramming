<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"href="style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<title>ユーザ情報更新</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
<p style="margin-left:1600px">
<font color="white">${userInfo.name} さん</font></p>
<a href="LogoutServlet"><p class="right"><font color="red">ログアウト</font></p></a>
</nav>
<h2 class="title">ユーザ情報更新</h2>
<form action="UserList.html" method="post">
<p class="center" style="margin-right:100px">ログインID　　　
${kousinUser.loginId}
<input type="hidden" value="${kousinUser.loginId}" name="loginId"><br>
</p>
<p class="center">パスワード
<input type="text" name="pass" style="margin-left:20px"><br>
</p>
<p class="center" style="margin-right:10px">パスワード(確認)
<input type="text" name="pass" style="margin-right:13px"><br>
</p>
<p class="center">ユーザ名
<input style="margin-left:35px" type="text" value="${kousinUser.name}" name="username"><br>
</p>
<p class="center">生年月日
<input type="date" value="${kousinUser.birthDate}"style="margin-left:20px" name="birth"><br>
<p class="center">
<input type="submit" style="margin-top:20px" value="更新">
</form>
<p class="center" style="margin-right:270px;margin-top:30px">
<a href="UserListServlet">戻る</a>
</body>
</html>