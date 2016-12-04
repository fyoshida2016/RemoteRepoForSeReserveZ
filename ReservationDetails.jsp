<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="model.User"%>
<%@ page import="model.Room"%>
<%@ page import="model.Reservation"%>
<%@ page import="java.util.LinkedList"%>
<%
	if (session.getAttribute("LoginUser") == null) {
		response.sendRedirect("Login.jsp");
		return;
	}
	User loginUser = (User) session.getAttribute("LoginUser");

	if (request.getAttribute("Reservation") == null) {
		response.sendRedirect("Login.jsp");
		return;
	}
	Reservation reservation = (Reservation) request.getAttribute("Reservation");
	User user=reservation.getUser();
	Room room=reservation.getRoom();
%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title id="title">予約詳細</title>
</head>
<body>
<center>

会議室予約システム

<p>
予約詳細
</p>

<table align="center" border="1" >
<tr>
<td align="center" colspan="2">
<img src="img/room<%= room.getRid() %>.jpg" width="200" height="160"/>
</td>
</tr>
<tr>
<td>場所</td>
<td><%= room.getBuildingName() %> <%= room.getFloor() %>階 <%= room.getRoomNumber() %>室</td>
</tr>

<tr>
<td align="center" colspan="2">
　
</td>
</tr>

<tr>
<td>利用開始時間</td>
<td>
<%= reservation.getStartYear() %>年
<%= reservation.getStartMonth() %>月
<%= reservation.getStartDay() %>日
<%= reservation.getStartHour() %>時
<%= reservation.getStartMinute() %>分
</td>
</tr>
<tr>
<td>利用時間</td>
<td>
<%= reservation.getPeriodHour() %>時間
<%= reservation.getPeriodMinute() %>分
</td>
</tr>

<tr>
<td align="center" colspan="2">
　
</td>
</tr>

<tr>
<td>予約者名</td>
<td>
<%= user.getName() %>
</td>
</tr>
<tr>
<td>予約者メールアドレス</td>
<td>
<%= user.getEmail() %>
</td>
</tr>

</table>

<Form method="post" action="ReservationDeleteServlet">
<input type="hidden" name="RID" value="<%= reservation.getRid() %>" />
<input type="submit" value="予約を削除する" />
</Form>

<font size="4">&copy;</font> H28 Software Engineering All Right Reserved.

</center>
</body>
</html>