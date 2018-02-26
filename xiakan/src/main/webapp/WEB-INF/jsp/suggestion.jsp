<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员</title>
    

     <link type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
   
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/my.js"></script>
  </head>
  
  <body>
   <jsp:include page="msIndex.jsp"></jsp:include>

	
	<div id="suggession" class="center-block" style="width:70%;height:100%;background-color:#ebebeb;padding:2%;">
		<h2>建议</h2>
		
		<c:forEach items="${suglist}" var="sug"> 
		<div class="panel panel-primary pull-left" style="width: 35%;margin-left:10% ">
  <div class="panel-heading" >${sug.time}</div>
  <div class="panel-body">${sug.content}</div>
</div>
           </c:forEach>
	</div>

  </body>
</html>
