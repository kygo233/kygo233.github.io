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
    <title>网易云</title>
   
  </head>
  
  <body >
<jsp:include page="top.jsp"></jsp:include>

<div class="panel panel-default" style="width:60%;margin-left: auto;
  margin-right: auto;">
  <!-- Default panel contents -->
  <div class="panel-heading" style="background-color: #FFF">
    <ul id="music-nav" class="nav nav-tabs">
   <li role="presentation" class="active"><a href="wyy?i=1">云音乐飙升榜</a></li>
   <li role="presentation" ><a href="wyy?i=2">UK</a></li>
   <li role="presentation"><a href="wyy?i=3">BB</a></li>
   <li role="presentation"><a href="wyy?i=4">中国TOP排行榜</a></li>
   <li role="presentation"><a href="wyy?i=5">云音乐电音榜</a></li>
</ul>

</div>

  <!-- Table -->
  <table class="table table-responsive table-condensed">
   <thead>
      <tr >
      <th width="10%">#</th>
       <th width="50%">歌曲</th>
        <th width="20%">歌手</th>
         <th width="20%">时长</th>
        
      </tr>
   </thead>
   <tbody id="ajax-table">
      
      <c:forEach items="${wyylist}" var="wyyrank"> 
       <tr>
        <th scope="row" width="10%">${wyyrank.id}</th>
         <td width="50%"><a href="${wyyrank.url}" target="_blank">${wyyrank.name}</a></td>
          <td width="20%">${wyyrank.author}</td>
           <td width="20%">${wyyrank.duration}</td>
            
      </tr>
   </c:forEach>
   </tbody>
  </table>
</div>
  </body>
</html>
