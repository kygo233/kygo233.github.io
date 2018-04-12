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
    
    <title>管理员登录</title>
    
	
  </head>
  
  <body>
  <jsp:include page="top.jsp"></jsp:include>
  <div class="center-block" style="width: 20%;height:auto;padding:10px;">
        <form action="/mslogin" method="post">
              <div class="form-group ">
                <label class="sr-only" for="exampleInputName3">用户名：</label>
                <input maxlength="11" name="name" type="text" class="form-control" id="exampleInputName1" placeholder="Name">
              </div>
              <div class="form-group " style="margin-top: 30px;">
                <label class="sr-only" for="exampleInputPassword2">密码：</label>
                <input maxlength="11" name="password" type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
              </div>
               <div class="form-group ">
                <button id="loginsub" type="submit"  class="btn btn-primary center-block" style="margin-top: 30px;width: 100%">管理员登录</button>
              </div>
          </form>        
        
     
      <c:if test="${! empty msg}">
       <div  class="alert alert-danger  center-block" role="alert">${msg}</div>
          </c:if>
     
       
  </div>
  </body>
</html>
