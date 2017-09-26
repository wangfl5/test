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

		<title>修改密码</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
		function check(){
			var oldpsw =document.getElementById("oldpassword").value;
			var psw =document.getElementById("password").value;
			if(psw==''){
				alert("新密码不能为空！");
				return false;
			}
			if(oldpsw==psw){
				alert("新密码不能与原密码相同");
				return false;
			}	
			var psws =document.getElementById("passwords").value;
			if(psw!=psws){
				alert("确认密码与新密码不同！");
				return false;
			}
			return true;
		}
		
		</script>
	</head>
	<body>
		<div class="formbody">
			<div class="formtitle">
				<span>修改密码</span>
			</div>
			<form action="updatePsw.action" method="post" onsubmit="return check()">
				<ul class="forminfo">
					<li>
						<label>
							原密码
						</label>
						<input id="oldpassword" type="text" readonly="readonly" class="dfinput" value="${staff.password}" />
						<input name="staff_id" type="hidden" value="${staff.staff_id}"/>
					</li>
					<li>
						<label>
							新密码
						</label>
						<input name="staff_password" id="password" type="text" class="dfinput"/>
					</li>
					<li>
						<label>
							确认密码
						</label>
						<input name="staff_passwords" id="passwords" type="text" class="dfinput"/>
					</li>
					<li>
						<label>
							&nbsp;
						</label>
						<input type="submit" class="btn" value="确认保存" />
					</li>
				</ul>
			</form>

		</div>


	</body>
</html>
