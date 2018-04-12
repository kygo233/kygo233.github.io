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
    <title>首页</title>
   
    
  </head>
  
  <body>
    <jsp:include page="top.jsp"></jsp:include>
    <div class="jumbotron " style="margin:0 auto;padding-left:15%;padding-right:15%;">
   <h1>${note.title}</h1>
   <p>${note.content}</p>
   
</div>
   </body>
</html>
