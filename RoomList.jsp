<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="model.User"%>
<%@ page import="model.Room"%>
<%@ page import="java.util.LinkedList"%>
<%

	if (session.getAttribute("LoginUser") == null) {
		response.sendRedirect("Login.jsp");
		return;
	}
	User loginUser = (User) session.getAttribute("LoginUser");

	if (request.getAttribute("Rooms") == null) {
		response.sendRedirect("Login.jsp");
		return;
	}
	LinkedList<Room> rooms = (LinkedList<Room>) request.getAttribute("Rooms");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title id="title">会議室一覧</title>
</head>
<body>
<center>

会議室予約システム

<p>
会議室一覧
</p>

<table align="center" border="1">
<thead>
<tr>
<td>写真</td>
<td>場所</td>
<td>面積（平米）</td>
<td>収容人数</td>
<td></td>
</tr>
</thead>
<tbody>
<% for(Room room :rooms){ %>
<tr>
<td><img src="img/room<%= room.getRid() %>.jpg" width="50" height="40"/></td>
<td><%= room.getBuildingName() %> <%= room.getFloor() %>階 <%= room.getRoomNumber() %>室</td>
<td><%= room.getArea() %></td>
<td><%= room.getCapacity() %></td>
<td>
<form method="post" action="RoomDetailsServlet">
<input type="hidden" name="RID" value="<%= room.getRid() %>" />
<input type="submit" value="詳細" />
</form>
</td>
<tr>
<%}%>
</tbody>
</table>
</form>

<font size="4">&copy;</font> H28 Software Engineering All Right Reserved.

</center>
</body>
</html>