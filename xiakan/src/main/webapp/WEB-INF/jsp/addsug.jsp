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

<title>意见反馈</title>

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
		<div  style="width:78%;min-height:500px; float:right;margin-top: 20px;">
		 <form  method="post" action="/createsug"  >
		反馈: <textarea  name="content"   cols="100" rows="8" style="width:100%;height:200px;"></textarea>
		<br/>
		<input type="submit" name="button" value="提交内容" /> 
	</form>
		<c:if test="${! empty msg}">
        <div  class="alert alert-danger  center-block" role="alert" style="width:50%;">${msg}</div>
       </c:if>
		   
		</div>

	</div>
</body>
</html>
