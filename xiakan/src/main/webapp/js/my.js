$(document).ready(function(){
	

	$(".navbar-nav").find("li").each(function () {
        var a = $(this).find("a:first")[0];
        if ($(a).attr("href") === location.pathname) {
            $(this).addClass("active");
        } else {
            $(this).removeClass("active");
        }
    });
	$(".nav-pills").find("li").each(function () {
        var a = $(this).find("a:first")[0];
        if ($(a).attr("href") === location.pathname) {
            $(this).addClass("active");
        } else {
            $(this).removeClass("active");
        }
    });
	
	$(".nav-tabs").find("li").each(function () {
        var a = $(this).find("a:first")[0];
        if ($(a).attr("href") === location.pathname) {
            $(this).addClass("active");
        } else {
            $(this).removeClass("active");
        }
    });

	
     $("#loginsub").click(function(even){
	    //用户名或密码为空
	   if(($('#exampleInputName1').val()=="") || ($('#exampleInputPassword3').val()==""))
	      {
		   $("#warn").removeClass("hidden");
		   $("#warn").html('<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>用户名或密码不能为空');
		   even.preventDefault();
		  }
	   else
	    { 
		   ajaxRequest();
	    }
	   }
	 )
	 
	  $("#regbtn").click(function(even){
	    //用户名或密码为空
	   if(($('#regpsd').val())!=($('#regpsd1').val()))
	      {
		   $("#regwarn").removeClass("hidden");
		   $("#regwarn").html('<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>2次密码不一样');

		   even.preventDefault();
		  }
		 
		 if(($('#regName').val()=="") || ($('#regpsd').val()=="")|| ($('#regpsd1').val()==""))
	      {
		   $("#regwarn").removeClass("hidden");
		   $("#regwarn").html('<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>请填写用户名或密码');

		   even.preventDefault();
		  } 
		
	 }
	 )
	 
	 	  $("#regpsd1").blur(function(even){
	    //用户名或密码为空
	       if(($('#regpsd').val())!=($('#regpsd1').val()))
	      {
		   $("#regwarn").removeClass("hidden");
		   $("#regwarn").html('<span class="glyphicon glyphicon glyphicon-remove" aria-hidden="true"></span>2次密码不一样');
		   even.preventDefault();
		  }
		  
		   if(($('#regpsd').val())==($('#regpsd1').val()) && $('#regpsd').val()!="" && $('#regpsd1').val()!="")
	       {
		   $("#regwarn").removeClass("hidden");
		   $("#regwarn").html('<span class="glyphicon glyphicon glyphicon-ok" aria-hidden="true"></span>2次密码一样');
		   
		  }
		
	 }
	 )
	 
//	   $("#music-nav > li").click(function(){
//		   $(this).addClass("active");
//		   
//	   });
   
 
});

function ajaxRequest() {
	var name=$("#exampleInputName1").val();
	var pass=$("#exampleInputPassword3").val();
    $.ajax({
      url: "/login",
      type: "POST",
      dataType: "text",
     // contentType:"application/json;charset=utf-8",
      data: {"name": name,"password": pass},
      async: true,
      success: function(data) {
    	//  alert(data+$("#exampleInputPassword3").val());
       if(data=="ok")
    	   {  
    	     window.location.reload(); 
    	   }
       else
    	   {  $("#warn").removeClass("hidden");
		     $("#warn").html('<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>用户名或密码错误');
		//     even.preventDefault();  
    	   }
      },

    });
  }

function ajaxA(obj) {
	var url=$(obj).attr("href");
	var title=$(obj).text();
	var category=document.title;
    $.ajax({
      url: "/record",
      type: "POST",
      dataType: "text",
     // contentType:"application/json;charset=utf-8",
      data: {"url": url,"title": title,"category": category},
      async: true,
      success: function(data) {  	
    	},
    });
  }

function set1(obj) {
	var div=$(obj).find("div");
	var id=div.text();
	 $.ajax({
	      url: "/setnote",
	      type: "POST",
	      dataType: "text",
	     // contentType:"application/json;charset=utf-8",
	      data: {"id": id},
	      async: true,
	      success: function(data) {  
	    	  alert(data)
	    	},
	    });
    
   
  }

function sethref(m,obj){
	var s="/sort";
	var a=$(obj).attr("href",s);
}


