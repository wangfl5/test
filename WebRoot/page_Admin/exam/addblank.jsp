<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>新增填空题</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
		function check(){
			var s_content =document.getElementById("s_content").value;
			if(s_content==''){
				alert("题目不为空！");
				return false;
			}
			var kinds =document.getElementById("kinds").value;
			if(kinds==''){
				alert("题目分类不为空！");
				return false;
			}
			var s_value =document.getElementById("s_value").value;
			if(s_value==''){
				alert("分值不为空！");
				return false;
			}
			return true;
		}
		</script>
	</head>

	<body>

		<div class="formbody">

			<div class="formtitle">
				<span>题目信息</span>
			</div>
			<form action="saveblank.action" method="post" onsubmit="return check()">
				<ul class="forminfo">
					<li>
						<label>
							题目<b>*</b>
						</label>
						<textarea name="s_content" id="s_content" class="textinput" /></textarea>
					</li>
					<li>
						<label>
							题目分类<b>*</b>
						</label>
						<div class="vocation">
    					<select class="select3" style="width: 152px;" name="kinds" id="kinds">
    					<option>采编</option>
    					<option>外呼</option>
    					<option>接续</option>
    					<option>话务</option>
    					</select>
    					</div>
					</li>
					<li>
						<label>
							分值<b>*</b>
						</label>
						<input name="s_value" id="s_value" type="text" class="dfinput"
							style="width:80px" />
					</li>
					
					<li>
						<label>
							答案<b>*</b>
						</label>
						<textarea name="s_standard" class="textinput" /></textarea>
					</li>
					<li>
						<label>
							&nbsp;
						</label>
						<input name="" type="submit" class="btn" value="确认保存" />
					</li>
				</ul>
			</form>

		</div>


	</body>
</html>
