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

		<title>更新员工信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/datepicker/WdatePicker.js"></script>
	</head>

	<body>

		<div class="formbody">

			<div class="formtitle">
				<span>基本信息</span>
			</div>
			<form action="updateStaff.action" method="post">
				<ul class="forminfo">
					<li>
						<label>
							员工ID
						</label>
						<input name="staff_id" type="text" class="dfinput"
							disabled="disabled" value="${staff.staff_id}" />
						
						<i>ID不能修改</i>
					</li>
					<li>
						<label>
							员工姓名
						</label>
						<input name="staff_name" type="text" class="dfinput"
							value="${staff.staff_name}" />
					</li>
					<li>
						<label>
							登录密码
						</label>
						<input name="staff_password" type="text" class="dfinput"
							value="${staff.password}" />
					</li>
					<li>
						<label>
							邮箱
						</label>
						<input name="email" id="email" type="text" class="dfinput"
							value="${staff.email}" />
					</li>
					<li>
						<label>
							入职时间
						</label>
						<input name="worktime" id="worktime" type="text" class="dfinput"
						style="width: 180px"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" 
							value="${staff.worktime}" />
					</li>
					<li>
						<label>
							职位
						</label>
						<input name="job" id="job" type="text" class="dfinput"
							value="${staff.job}" />
					</li>
					
					<li>
						<label>
							描述
						</label>
						<textarea name="staff_desc" class="textinput">${staff.staff_desc}</textarea>
						<i>不能超过100个字符</i>
					</li>
					<s:if test='#request.staff.isAdmin=="false"'>
					<li>
						<input name="isAdmin" type="checkbox" value="true" />
						设置为管理员
					</li>
					</s:if>
					<s:else>
					<li>
						
						<input name="isAdmin" type="checkbox" value="false" />
						取消管理员权限
						
					</li>
					</s:else>
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
