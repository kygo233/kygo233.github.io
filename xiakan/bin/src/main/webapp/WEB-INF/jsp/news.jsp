<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>新闻</title>
  </head>
  
  <body>
  <jsp:include page="top.jsp"></jsp:include>
   <div style="width:100%;padding-left:200px">
<div class="list-group" style="width:500px;float:left">
  <a href="#" class="list-group-item active">
   新浪
  </a>
  
  <c:forEach items="${sinalist}" var="sinanews"> 
    <a href="${sinanews.url}" class="list-group-item" target="_blank" onclick="ajaxA(this)">${sinanews.title}</a>
   </c:forEach>
</div>

<div class="list-group" style="width:500px;margin-left:20px;float:left;">
  <a href="#" class="list-group-item active">
  网易
  </a>
  <c:forEach items="${wylist}" var="wynews"> 
    <a href="${wynews.url}" class="list-group-item" target="_blank">${wynews.title}</a>
   </c:forEach>
</div>

<div class="list-group" style="width:500px;float:left;">
  <a href="#" class="list-group-item active">
  3DM
  </a>
  <c:forEach items="${dm3list}" var="dm3news"> 
    <a href="${dm3news.url}" class="list-group-item" target="_blank">${dm3news.title}</a>
   </c:forEach>
</div>
</div>
   
   
   
  </body>
</html>
