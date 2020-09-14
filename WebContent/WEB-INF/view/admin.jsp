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
<form action="/2020_Kadai09/Servlet01" method="post">
		<br> <input type="submit" value="Top画面">
	</form>
<p>ここは管理者画面です。</p>
<p>===================================================================================</p>
	<%
		ArrayList<Bean> list = (ArrayList<Bean>) request.getAttribute("list");
	%>

		<%
			for (int i = 0; i < list.size(); i++) {
				Bean result = list.get(i);
		%>
			id:<%=result.getId() %>
			投稿者:<%=result.getName()%><br>
			日付:<%=result.getDpost()%>
			投稿時間:;;;;;;<%=result.getTpost()%>
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



