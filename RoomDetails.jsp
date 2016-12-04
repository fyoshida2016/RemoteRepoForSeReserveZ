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

	if (session.getAttribute("Room") == null) {
		response.sendRedirect("Login.jsp");
		return;
	}
	Room room = (Room) session.getAttribute("Room");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title id="title">会議室詳細</title>
</head>
<body>
<center>

会議室予約システム

<p>
会議室詳細
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
<td>面積（平米）</td>
<td><%= room.getArea() %></td>
</tr>
<tr>
<td>収容人数</td>
<td><%= room.getCapacity() %></td>
</tr>
<tr>
<td>内線番号</td>
<td><%= room.getTel() %></td>
</tr>
<tr>
<td>ホワイトボードの数</td>
<td><%= room.getWhiteboard() %></td>
</tr>
<tr>
<td>プロジェクタの有無</td>
<td>
<%
if(room.getProjecter()==0){
	out.println("－");
}else{
	out.println("○");
}
%>
</td>
</tr>
<tr>
<td>スクリーンの有無</td>
<td>
<%
if(room.getScreen()==0){
	out.println("－");
}else{
	out.println("○");
}
%>
</td>
</tr>
<tr>
<td>外部入力（HDMI）の有無</td>
<td>
<%
if(room.getHdmi()==0){
	out.println("－");
}else{
	out.println("○");
}
%>
</td>
</tr>
<tr>
<td>外部入力(D-sub)の有無</td>
<td>
<%
if(room.getDsub()==0){
	out.println("－");
}else{
	out.println("○");
}
%>
</td>
</tr>
<tr>
<td>外部入力（コンポジット）の有無</td>
<td>
<%
if(room.getComposite()==0){
	out.println("－");
}else{
	out.println("○");
}
%>
</td>
</tr>
<tr>
<td>外部入力（ステレオミニ）の有無</td>
<td>
<%
if(room.getStereomini()==0){
	out.println("－");
}else{
	out.println("○");
}
%>
</td>
</tr>

</table>
</form>

<Form method="post" action="ReservationInsert.jsp">
<input type="submit" value="この部屋を予約する" />
</Form>

<font size="4">&copy;</font> H28 Software Engineering All Right Reserved.

</center>
</body>
</html>