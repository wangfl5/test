<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active")
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
})	
</script>

  </head>
  
 <body style="background:#f0f9fd;">
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>考试模块
    </div>
    <ul class="menuson">
       <li><cite></cite><a href="queryMyPaper.action" target="rightFrame">我的考试</a><i></i></li>
       <li><cite></cite><a href="queryMyResult.action?staff_id=${session.login_id}" target="rightFrame">我的考试结果查看</a><i></i></li>
    </ul> 	
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>培训模块
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="querymytrain.action?Staff_ids=${session.login_id}" target="rightFrame">我的培训</a><i></i></li>
       
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>问卷模块</div>
    <ul class="menuson">
       <li><cite></cite><a href="querymyquestion.action?staff_id=${session.login_id}" target="rightFrame">我的问卷</a><i></i></li>
    </ul>    
    </dd> 
     
   	<dd><div class="title"><span><img src="images/leftico03.png" /></span>信息管理</div>
    <ul class="menuson">
       <li><cite></cite><a href="changeMypsw.action?staff_id=${session.login_id}" target="rightFrame">修改密码</a><i></i></li>
    </ul>    
    </dd>  
    </dl>
    
</body>
</html>
