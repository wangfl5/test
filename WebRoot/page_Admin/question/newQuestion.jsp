<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
		<base href="<%=basePath%>">

		<title>新增问卷</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/datepicker/WdatePicker.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
  			$("#btn").click(function(){
    			$("#new").append("<li>"
    			+"<label>题目<b>*</b></label><input name='s_content' id='s_content' type='text' class='dfinput' />"
    			+"</li>"
    			+"<li>"
    			+"<label>选项<b>*</b></label>A  &nbsp;<input name='s_answer1' type='text' class='dfinput' />&nbsp; &nbsp; &nbsp;B  &nbsp;<input name='s_answer2' type='text' class='dfinput' />"
    			+"</li>"
    			+"<li>"
    			+"<label></label>C  &nbsp;<input name='s_answer3' type='text' class='dfinput' />&nbsp; &nbsp; &nbsp;D  &nbsp;<input name='s_answer4' type='text' class='dfinput' />"
    			+"</li>");
  			});
		});
		function checks(){
			var q_name =document.getElementById("q_name").value;
			if(q_name==''){
				alert("问卷名字不为空！");
				return false;
			}
			var q_starttime =document.getElementById("q_starttime").value;
			if(q_starttime==''){
				alert("问卷开始时间不为空！");
				return false;
			}
			var q_endtime =document.getElementById("q_endtime").value;
			if(q_endtime==''){
				alert("问卷开始时间不为空！");
				return false;
			}
           	
			return true;
		}
		
		</script>
	</head>

	<body>
		<div class="formbody">
			<div class="formtitle">
				<span>调查问卷基本信息</span>
			</div>
			<form action="saveQuestion.action" method="post"
				onsubmit="return checks()">
				<ul class="forminfo">
					<li>
						问卷名称
						<b>*</b> &nbsp;
						<input name="q_name" id="q_name" type="text" class="dfinput" />
						&nbsp;&nbsp;&nbsp; 问卷开始时间
						<b>*</b>&nbsp;
						<input name="q_starttime" id="q_starttime" type="text" class="dfinput"
							style="width: 180px"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
						&nbsp;&nbsp;&nbsp; 问卷截止时间
						<b>*</b>&nbsp;
						<input name="q_endtime" id="q_endtime" type="text" class="dfinput"
							style="width: 180px"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
						<input name="set_id" type="hidden" value="${session.login_id}"/>
					</li>
				</ul>

				<div class="formtitle">
					<span>新增题目</span>
				</div>
				<ul class="forminfo" id="new">
					<li>
						<label>
							题目<b>*</b>
						</label>
						<input name="s_content" id="s_content" type="text" class="dfinput" />
					</li>
					<li>
						<label>
							选项<b>*</b>
						</label>
						
						A  &nbsp;<input name="s_answer1" type="text" class="dfinput" />
						 &nbsp; &nbsp; &nbsp;
						B  &nbsp;<input name="s_answer2" type="text" class="dfinput" />
					</li>
					
					<li>
						<label></label>
						
						C  &nbsp;<input name="s_answer3" type="text" class="dfinput" />
						 &nbsp; &nbsp; &nbsp;
						D  &nbsp;<input name="s_answer4" type="text" class="dfinput" /> 
					</li>
				</ul>
				&nbsp; 
				<input type="button" id="btn" class="btn" value="新增一道题目"/>
				&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
				<input name="" type="submit" class="btn" value="确认保存" />
			</form>
		</div>
	</body>
</html>
