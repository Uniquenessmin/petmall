<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录</h1>
	<!-- 从request取查询参数 -->
	<p>param.info:${param.info}</p>
	
	<!--EL 从作用域application，session，request，pageScope的getAttribute中取 -->
	<p>info:${info}</p>
	<p>loginfo:${loginfo}</p>
	<p>a:${a}</p>
	
	
	
</body>
</html>