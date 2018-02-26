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
    
    <title>注册</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <jsp:include page="top.jsp"></jsp:include>
    
    <div id="register" class="center-block" style="width:300px;height:auto;padding:20px;border-radius:5px;">
   <form action="/register" method="post">
  <div class="form-group ">
    <label class="sr-only" for="exampleInputName3">用户名：</label>
    <input type="text" name="name" class="form-control" id="regName" placeholder="用户名">
  </div>
  <div class="form-group ">
    <label class="sr-only" for="exampleInputPassword2">密码：</label>
    <input type="password" name="password"  class="form-control" id="regpsd" placeholder="密码">
  </div>
   <div class="form-group ">
    <label class="sr-only" for="exampleInputPassword2">密码：</label>
    <input type="password" class="form-control" id="regpsd1" placeholder="确认密码">
  </div>
  <div >
 
  <button  id="regbtn" type="submit" class="btn btn-primary btn-block">注册</button>
  </div>
  
</form>


</div>

<c:choose>
    <c:when test="${empty msg }">
      <div id="regwarn" class="alert alert-danger hidden center-block" role="alert" style="width:260px;"> 
          </div>
          </c:when>
   
    <c:otherwise>
        <div id="regwarn" class="alert alert-danger  center-block" role="alert" style="width:260px;">${msg}</div>
    </c:otherwise>
</c:choose>

    
  </body>
</html>
