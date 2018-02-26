<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>新闻分类</title>
</head>

<body>
	<jsp:include page="top.jsp"></jsp:include>
	
	<div class="center-block" style="width:80%;height: auto">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="/sort?i=1">国内</a></li>
			<li role="presentation"><a href="/sort?i=2">国际</a></li>
			<li role="presentation"><a href="/sort?i=3">军事</a></li>
			<li role="presentation"><a href="/sort?i=4">社会</a></li>
			<li role="presentation"><a href="/sort?i=5">互联网</a></li>
			<li role="presentation"><a href="/sort?i=6">房产</a></li>
			<li role="presentation"><a href="/sort?i=7">汽车</a></li>
			<li role="presentation"><a href="/sort?i=8">体育</a></li>
			<li role="presentation"><a href="/sort?i=9">娱乐</a></li>
			<li role="presentation"><a href="/sort?i=10">游戏</a></li>
			<li role="presentation"><a href="/sort?i=11">教育</a></li>

		</ul> 
		<div class="list-group">
			<a href="#" class="list-group-item active"> </a>
			<c:forEach items="${newslist}" var="news">
				<a href="${news.url}" class="list-group-item " target="_blank"  onclick="ajaxA(this)">${news.title}  ————  ${news.author} ${news.time}</a>
			</c:forEach>
		</div>
	</div>



</body>
</html>
