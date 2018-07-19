<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"href="style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<title>ユーザ削除確認</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
<p style="margin-left:1600px">
<font color="white">${userInfo.name} さん</font></p>
<a href="LoginServlet"><p class="right"><font color="red">ログアウト</font></p></a>
</nav>
<h2 class="title">ユーザ削除確認</h2>
<p class="center">ログインID： ${userDetail.loginId}<br>を本当に削除してよろしいでしょうか。</p>
<p class="center">
<a href="UserListServlet">キャンセル</a>　　　
<form action="DeleteServlet" method="post">
<input type="hidden" value="${userDetail.loginId}" name="loginId">
<input type="submit" style="margin-left:920px" value="OK">　　　</form>
</body>
</html>