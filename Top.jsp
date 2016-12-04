<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="model.User"%>
<%
	if (session.getAttribute("LoginUser") == null) {
		response.sendRedirect("Login.jsp");
		return;
	}
	User loginUser = (User) session.getAttribute("LoginUser");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title id="title">Top</title>
</head>
<body>
<center>

会議室予約システム

<Form method="post" action="RoomListServlet">
<input type="submit" value="会議室一覧" />
</Form>

<Form method="post" action="ReservationListServlet">
<input type="submit" value="予約一覧" />
</Form>

<font size="4">&copy;</font> 2016 Software Engineering All Right Reserved.

</center>
</body>
</html>