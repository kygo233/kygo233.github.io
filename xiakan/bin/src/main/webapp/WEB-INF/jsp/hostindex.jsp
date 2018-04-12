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

<title>我的信息</title>

</head>

<body>
	<jsp:include page="top.jsp"></jsp:include>

	<div class="center-block" style="width:70%;height:100%;padding:2%;">
		<h2>个人中心</h2>
		<div style="width:18%;float: left;">
			<ul class="nav nav-pills nav-stacked">
				<!--   <li role="presentation" ><a href="#">个人信息</a></li> -->
				<li role="presentation"><a href="/getRecord">浏览记录</a></li>
				<li role="presentation"><a href="/toaddsug">意见反馈</a></li>
			</ul>
		</div>
		<div  style="width:78%;min-height:500px; float:right;">
		
		<c:forEach items="${relist}" var="re"> 
           <a href="${re.url}" class="list-group-item" target="_blank" onclick="ajaxA(this)">${re.title}<span style="float: right">${re.time}</span></a>
        </c:forEach>
		   
		</div>

	</div>
</body>
</html>
