<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
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
        <li><cite></cite><a href="querysubject.action" target="rightFrame">题库管理</a><i></i></li>
        <li><cite></cite><a href="page_Admin/exam/addsingle.jsp" target="rightFrame">新增单选题</a><i></i></li>
        <li><cite></cite><a href="page_Admin/exam/addmulti.jsp" target="rightFrame">新增多选题</a><i></i></li>
        <li><cite></cite><a href="page_Admin/exam/addblank.jsp" target="rightFrame">新增填空题</a><i></i></li>
        <li><cite></cite><a href="queryAllPaper.action?exam_name=&exam_start=&exam_end=" target="rightFrame">试卷管理</a><i></i></li>
        <li><cite></cite><a href="newPaper.action" target="rightFrame">新增试卷</a><i></i></li>
        <li><cite></cite><a href="queryAllResult.action" target="rightFrame">考试结果查询</a><i></i></li>
        </ul>     
    </dd>
        
    
    <dd><div class="title"><span><img src="images/leftico01.png" /></span>培训模块</div>
    <ul class="menuson">
        <li><cite></cite><a href="querytrain.action" target="rightFrame">培训计划管理</a><i></i></li>
        <li><cite></cite><a href="Newtrain.action" target="rightFrame">新建培训计划</a><i></i></li>
        </ul>     
    </dd> 
    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>问卷模块</div>
    <ul class="menuson">
        <li><cite></cite><a href="queryAllquestion.action" target="rightFrame">问卷管理</a><i></i></li>
        <li><cite></cite><a href="page_Admin/question/newQuestion.jsp" target="rightFrame">新增调查问卷</a><i></i></li>
    </ul>    
    </dd>  
    <dd><div class="title"><span><img src="images/leftico01.png" /></span>管理模块</div>
    <ul class="menuson">
        <li><cite></cite><a href="query.action" target="rightFrame">员工信息管理</a><i></i></li>
        <li><cite></cite><a href="page_Admin/manage/NewStaff.jsp" target="rightFrame">新增员工信息</a><i></i></li>
    </ul>    
    </dd>  
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>个人模块
    </div>
    <ul class="menuson">
       <li><cite></cite><a href="queryMyPaper.action?staff_id=${session.login_id}" target="rightFrame">我的考试</a><i></i></li>
       <li><cite></cite><a href="queryMyResult.action?staff_id=${session.login_id}" target="rightFrame">我的考试结果查看</a><i></i></li>
       <li><cite></cite><a href="querymyquestion.action?staff_id=${session.login_id}" target="rightFrame">我的问卷</a><i></i></li>
       <li><cite></cite><a href="querymytrain.action?Staff_ids=${session.login_id}" target="rightFrame">我的培训</a><i></i></li>
       <li><cite></cite><a href="changeMypsw.action?staff_id=${session.login_id}" target="rightFrame">修改密码</a><i></i></li>
    </ul> 	
    </dd>
    </dl>
    
</body>
</html>

