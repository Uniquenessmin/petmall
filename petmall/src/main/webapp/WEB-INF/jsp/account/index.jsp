<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%//@include file="abount.jsp" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<h1><a href="/o/ab">账号首页</a></h1>
	<h1><a href="/o/cb">注销</a></h1>
	<ul>
	<%ArrayList<String> list = (ArrayList<String>) request.getAttribute("mList");
	for(int i=0;i<list.size();i++){
	%>
	<li><%= list.get(i)%></li>
	
	<%	
	}
	%>
	</ul>
	<hr>
	<!-- jstl / th -->

	<h1>mList</h1>
	<ul>
	<!-- 从作用域（application，session，request）查找 mList -->
	<!-- ${m} EL表达式语言 -->
		<c:forEach var="m" items="${mList}">
		<li>${m}</li>
		</c:forEach>
</ul>
<hr>
<h1>session List</h1>
	<ul>
	<!-- 从作用域（application，session，request）查找 mList -->
	<!-- ${m} EL表达式语言 -->
		<c:forEach var="m" items="${reqList}">
		<li>${m}</li>
		</c:forEach>
</ul>
</body>
</html>