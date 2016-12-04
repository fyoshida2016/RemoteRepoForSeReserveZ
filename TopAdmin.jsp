<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="model.User"%>
<%
	if (session.getAttribute("LoginUser") == null) {
		response.sendRedirect("LoginAdmin.jsp");
		return;
	}
	User loginUser = (User) session.getAttribute("LoginUser");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title id="title">管理者Top</title>
</head>
<body>
<center>

会議室予約システム 管理者サイト

<Form method="post" action="UserListServlet">
<input type="submit" value="ユーザ一覧" />
</Form>

<font size="4">&copy;</font> 2016 Software Engineering All Right Reserved.

</center>
</body>
</html>