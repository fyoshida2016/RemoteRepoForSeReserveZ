<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title id="title">管理者Login</title>
</head>
<body>
<center>

会議室予約システム 管理者サイト

<form method="POST" action="LoginAdminServlet" >

ログイン名
<input type="text" name="LoginName" />

<br />

パスワード
<input type="password" name="PassWord" />

<br />

<input type="submit" value="管理者としてログイン" />
</form>

<font size="4">&copy;</font> 2016 Software Engineering All Right Reserved.

</center>
</body>
</html>