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

		<title>新增员工</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/datepicker/WdatePicker.js"></script>
		<script type="text/javascript">
		function check() {
			var id = document.getElementById("id").value;
			if (id == '') {
				alert("员工ID不为空！");
				return false;
			}
			var name = document.getElementById("name").value;
			if (name == '') {
				alert("员工姓名不为空！");
				return false;
			}
			var psw = document.getElementById("passwords").value;
			if (psw == '') {
				alert("员工密码不为空！");
				return false;
			}
			return true;
		}
		function back(){
			
		}
		</script>
	</head>
	<body>
		<div class="formbody">
			<div class="formtitle">
				<span>基本信息</span>
			</div>
			<form action="saveStaff.action" method="post" onsubmit="return check()">
				<ul class="forminfo">
					<li>
						<label>
							员工ID<b>*</b>
						</label>
						<input name="staff_id" id="id" type="text" class="dfinput"/>
					</li>
					<li>
						<label>
							员工姓名<b>*</b>
						</label>
						<input name="staff_name" id="name" type="text" class="dfinput"/>
					</li>
					<li>
						<label>
							登录密码<b>*</b>
						</label>
						<input name="staff_password" id="passsword" type="text" class="dfinput"/>
					</li>
					<li>
						<label>
							邮箱
						</label>
						<input name="email" id="email" type="text" class="dfinput"/>
					</li>
					<li>
						<label>
							入职时间
						</label>
						<input name="worktime" id="worktime" type="text" class="dfinput"
						style="width: 180px"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
					</li>
					<li>
						<label>
							职位
						</label>
						<input name="job" id="job" type="text" class="dfinput"/>
					</li>
					<li>
						<label>
							描述
						</label>
						<textarea name="staff_desc" class="textinput"></textarea>
						<i>不能超过100个字符</i>
					</li>
					<li>
						<label>
							&nbsp;
						</label>
						<input type="submit" class="btn" value="确认保存" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" class="btn" value="返回" onclick="window.location.href='query2.action'"/>
					</li>
				</ul>
			</form>
		</div>
	</body>
</html>
