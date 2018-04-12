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
    
    <title>创建公告</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/default/default.css" />
		<script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor-min.js"></script>
		<script charset="utf-8" src="${pageContext.request.contextPath}/lang/zh-CN.js"></script>
		<script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="content"]', {
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
				});
			});
		</script>
  </head>
  
  <body>
    <jsp:include page="msIndex.jsp"></jsp:include>
<div id="note" class="center-block " style="width:70%;height:100%;padding:2%;">
		<div style="width:70%;">
			<ul class="nav nav-pills">

				<li ><a href="/getNote">历史公告</a></li>
				<li ><a href="/tocreateNote" >创建公告</a></li>
			</ul>
        <div id="create" class="">
		   <form  method="post" action="/createnote" style="width:700px;margin:0 auto;margin-top:50px;" >
		   <div class="input-group">

	      标题: <input  name="title"  style="width:300px;height:20px;" value="${note.title}" />  <br/>
	      </div>
	      <div class="input-group">
            内容: <textarea name="content" style="width:700px;height:200px;">KindEditor</textarea>
		<br/>
		</div>
		<input type="submit" name="button" value="提交内容" /> 
	</form>
	
	</div>	
		</div>

	</div>
	
	

  </body>
</html>
	     