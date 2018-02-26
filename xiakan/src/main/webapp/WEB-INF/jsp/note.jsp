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

  </head>
  
  <body>
    <jsp:include page="msIndex.jsp"></jsp:include>
     <div id="note" class="center-block " style="width:70%;height:100%;padding:2%;">
		
		<div style="width:70%;">
			<ul class="nav nav-pills">

				<li ><a href="/getNote">历史公告</a></li>
				<li ><a href="/tocreateNote" >创建公告</a></li>
			</ul>
<div id="notelist" >

		<c:forEach items="${notelist}" var="note"> 
          <div class="panel panel-default">
  <div class="panel-heading " style="height: auto">${note.title}<button type="button" class="btn btn-info btn-sm pull-right" onclick="set1(this)">设为公告<div class="hidden">${note.id}</div></button></div>
  
  <div class="panel-body">${note.content}</div>
</div>
        </c:forEach>
    
    </div>    
        
   
		</div>

	</div>
	
	

  </body>
</html>
