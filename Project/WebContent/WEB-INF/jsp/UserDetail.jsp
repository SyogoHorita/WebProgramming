<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"href="style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<title>ユーザ情報詳細参照</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
<p style="margin-left:1600px">
<font color="white">${userInfo.name} さん</font></p>
<a href="LogoutServlet"><p class="right"><font color="red">ログアウト</font></p></a>
</nav>
<h2 class="title">ユーザ情報詳細参照</h2>
<p class="center">ログインID　　　　　　　　　　　${userDetail.loginId}</p>
<p class="center">ユーザ名　　　　　　　　　　　${userDetail.name}</p>
<p class="center" style="margin-left:50px">生年月日　　　　　　　　　　　${userDetail.birthDate}</p>
<p class="center" style="margin-left:95px">登録日時　　　　　　　　　　　${userDetail.createDate}</p>
<p class="center" style="margin-left:95px">更新日時　　　　　　　　　　　${userDetail.updateDate}</p>
<p class="center" style="margin-right:270px;margin-top:50px">
<a href="UserListServlet">戻る</a>
</p>
</body>
</html>