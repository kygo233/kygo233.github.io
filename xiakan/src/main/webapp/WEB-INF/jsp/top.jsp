<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  <head>
     <link type="text/css"  href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet">
     <link type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
   
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/my.js"></script>
   
    
  </head>
  
  <body>
  <header>
    
  </header>
   <nav class="navbar navbar-default " >
  <div class="container" >
    <div class="navbar-header">
         
       <!--  <a class="navbar-brand" href="/">瞎看</a>  -->
        </div>
        <div id="navbar" class="collapse navbar-collapse" >
          <ul class="nav navbar-nav">
            <li><a href="/">Home</a></li>
            <li><a href="/news">新闻</a></li>
            <li><a href="/sort?i=1">分类</a></li>
            <li class="dropdown">
               <a href="#"  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">音乐<span class="caret"></span></a>
          
                 <ul  class="dropdown-menu">
                   <li><a href="wyy?i=1">网易云</a></li>
                   
                 </ul>
         
            </li>
       <!--     <li class="dropdown">
                 <a href="#"  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">视频<span class="caret"></span></a>
          
                    <ul  class="dropdown-menu">
                       <li><a href="yk">优酷</a></li>
                       <li><a href="ac">ACFUN</a></li>
                       
                    </ul>
            </li>
            -->  
             <li><a href="/tosearch">搜索</a></li>
          </ul>
          
          
     <ul class="nav navbar-nav navbar-right">
       
        <c:set var="name" value="${sessionScope.user.username}"/>
	      <c:choose> 
	      <c:when test="${empty name }">
				
				  <li class="dropdown"> <a href="#"  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">登录<span class="caret"></span></a>
          <div id="login" class="dropdown-menu" style=" width: 250px;height:auto;border:1px #66CCFF solid;border-radius:5px;padding:10px;">
            <button type="button" class="close pull-right" aria-label="Close" style="margin-bottom:10px;margin-top:-10px;"><span aria-hidden="true">&times;</span></button>
              <form onSubmit="return false">
              <div class="form-group ">
                <label class="sr-only" for="exampleInputName3">用户名：</label>
                <input maxlength="11" name="name" type="text" class="form-control" id="exampleInputName1" placeholder="Name">
              </div>
              <div class="form-group ">
                <label class="sr-only" for="exampleInputPassword2">密码：</label>
                <input maxlength="11" name="password" type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
              </div>
              <div class="row">
                <div class="col-md-6">
                  <div class="checkbox">
                    <label>
                      <input type="checkbox">
                      记住我 </label>
                  </div>
                </div>
                <div class="col-md-6">
                  <button id="loginsub" type="submit"  class="btn btn-primary pull-right">登录</button>
                </div>
              </div>
              
              </form>
         
             <div id="warn" class="alert alert-danger hidden" role="alert"> 
              </div>
          </div>
        </li>
                  <li><a href="/toregister">注册</a></li>
				
			</c:when>	
			<c:otherwise>
			  <li><a href="/tohostindex" style="padding: 0"><img src="${pageContext.request.contextPath}/image/tx.jpg" style="width:50px;height: 50px;" class=" img-circle" alt="Responsive image"></a></li>
                <li><a href="/tohostindex" ><c:out value="${name}"/></a></li>
				<li><a href="/loginout">登出</a></li>
			 </c:otherwise> 
			</c:choose>
				
       
     
      
      </ul>

        </div><!--/.nav-collapse -->
  </div>
</nav>
</body>
