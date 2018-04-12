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

<title>搜索</title>
</head>

<body>
	<jsp:include page="top.jsp"></jsp:include>
   <div class="container ">
	
		<div class="row center-block" style="width:30%;">
		<form action="/search" method="post">
			<div class="input-group input-group-lg ">
				<input type="text" name="word" class="form-control" placeholder="Search for..."  value="${word}" /> 
				<span class="input-group-btn">
					<button class="btn btn-default  btn-lg" type="submit">Go!</button>
				</span>
			</div>
			</form>
		</div>
	
	
	<div class="list-group center-block" style="width:800px;">  
    <c:forEach items="${searchRS}" var="news"> 
    <a href="${news.url}" class="list-group-item" target="_blank">${news.title}  ————  ${news.author} ${news.time}</a>
   </c:forEach>
   </div>

</div>
</body>
</html>
