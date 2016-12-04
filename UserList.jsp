<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="model.User"%>
<%@ page import="java.util.LinkedList"%>
<%
	if (session.getAttribute("LoginUser") == null) {
		response.sendRedirect("LoginAdmin.jsp");
		return;
	}
	User loginUser = (User) session.getAttribute("LoginUser");

	if (request.getAttribute("Users") == null) {
		response.sendRedirect("Login.jsp");
		return;
	}
	LinkedList<User> users = (LinkedList<User>) request.getAttribute("Users");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title id="title">ユーザ一覧</title>
</head>
<body>
<center>

会議室予約システム 管理者サイト

<p>
ユーザ一覧
</p>

<table align="center" border="1" >
<thead>
<tr>
<td>ユーザ名</td>
<td>Email</td>
<td>ユーザタイプ</td>
</tr>
</thead>
<tbody>
<% for(User user :users){ %>
<tr>
<td><%= user.getName() %></td>
<td><%= user.getEmail() %></td>
<td><% if(user.getUserType()==1) out.println("管理者"); %></td>
</tr>
<% } %>
</tbody>
</table>
</form>

<font size="4">&copy;</font> 2016 Software Engineering All Right Reserved.

</center>
</body>
</html>