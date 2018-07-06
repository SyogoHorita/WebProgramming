<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"href="style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<title>ユーザ一覧</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
<p style="margin-left:1600px">
<font color="white">${userInfo.name} さん</font></p>
<a href="LogoutServlet"><p class="right"><font color="red">ログアウト</font></p></a>
</nav>
<h2 class="title">ユーザ一覧</h2>
<a href="NewUserServlet"><p class="right">新規登録</p></a><br>
<form action="" method="post">
<p class="center">ログインID
<input type="text" style="margin-left:40px" name="id2">
<p class="center">ユーザ名
<input type="text" style="margin-left:55px" name="userName">
<p class="center" style="margin-left:165px">生年月日
<input type="date" style="margin-left:55px" name="date">～
<input type="date" name="date2">
</form>
<br>
<p class="center" style="margin-left:700px">
<input type="submit" value="検索">
<hr>

<div class="container">

	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">ログインID</th>
	      <th scope="col">ユーザ名</th>
	      <th scope="col">生年月日</th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var="user" items="${userList}" >
	    <tr>
	      <th scope="row">${user.loginId}</th>
	      <td>${user.name}</td>
	      <td>${user.birthDate}</td>
	      <td><a href="UserDetailServlet?loginId=${user.loginId}" class="btn btn-primary">詳細</a>
	      <a href="KousinServlet?loginId=${user.loginId}" class="btn btn-success">更新</a>
	      <button type="button" class="btn btn-danger">削除</button></td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
</div>
</body>
</html>