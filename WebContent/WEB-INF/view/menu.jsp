<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.Bean"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="./photo/jaian.jpg">
	<form action="/2020_Kadai09/Admin" method="post">
		<br> <input type="submit" value="管理者画面">
	</form>
	<br>
	<form action="/2020_Kadai09/Servlet01" method="post">
		投稿者<br>
		<input type="text" name="name" value="名無し"><br>
		内容<br>
		<textarea name="comment" rows="4" cols="40"></textarea>
		<br>
		<br> <input type="submit" value="送信"> <input type="reset" value="リセット">
	</form>
	<form method="POST" enctype="multipart/form-data" action="/2020_Kadai09/UploadServlet">
		投稿者<br>
		<input type="text" name="name" value="名無し"><br>
		<input type="file" name="file"><br>
		<input type="submit" value="アップロード">
	</form>
	<p>===================================================================================</p>
	<%
		ArrayList<Bean> list = (ArrayList<Bean>) session.getAttribute("list");
	%>

		<%
			for (int i = 0; i < list.size(); i++) {
				Bean result = list.get(i);
		%>
			id:<%=result.getId() %>
			投稿者:<%=result.getName()%><br>
			日付:<%=result.getDpost()%>
			投稿時間:<%=result.getTpost()%>
			編集時間:<%=result.getEdit()%><br>

		<%
		String str = result.getComment();
		if(str.endsWith(".jpg")) {%>
		<img src="./photo/<%=result.getComment() %>" alt="<%=result.getComment() %>"><br><br>
		<%} else if(str.endsWith(".png")) {%>
		<img src="./photo/<%=result.getComment() %>" alt="<%=result.getComment() %>"><br><br>
		<img src="./photo/">
		<%} else {%>
			<%=result.getComment() %><br><br>
		<% } %>
		<%} %>

</body>
</html>



