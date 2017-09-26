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

		<title>新增培训计划</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/datepicker/WdatePicker.js"></script>
		<script type="text/javascript">
		function check(){
			var train_title =document.getElementById("train_title").value;
			if(train_title==''){
				alert("培训主题不为空！");
				return false;
			}
			var train_time =document.getElementById("train_time").value;
			if(train_time==''){
				alert("培训时间不为空！");
				return false;
			}
			var train_place =document.getElementById("train_place").value;
			if(train_place==''){
				alert("培训地点不为空！");
				return false;
			}
			return true;
		}
		</script>
	</head>

	<body>

		<div class="formbody">

			<div class="formtitle">
				<span>基本信息</span>
			</div>
			<form action="Savetrain" method="post" enctype="multipart/form-data" onsubmit="check()">
				<ul class="forminfo">
					<li>
						<label>
							培训主题<b>*</b>
						</label>
						<input name="set_id" type="hidden" value="${session.login_id}"/>
						<input name="train_title" id="train_title" type="text" class="dfinput"/>
					</li>
					<li>
						<label>
							计划培训时间<b>*</b>
						</label>
						<input style="width:180px" name="train_time" id="train_time" type="text" class="dfinput"
							 onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
					</li>
					<li>
						<label>
							培训地点<b>*</b>
						</label>
						<input name="train_place" id="train_place" type="text" class="dfinput"/>
					</li>
					<li>
						<label>
							培训相关材料
						</label>
  						<s:file name="train_file" label="材料" cssStyle="height:30px;width:440px;font-size:18px;"></s:file>
					</li>
					<li>
						<label>
							选择参与员工
						</label>
						<table class="tablelist2">
							<tr>
								<th width="50">
								</th>
								<th>
									用户
								</th>
								<th>
									姓名
								</th>
							</tr>
							<tbody>
								<s:iterator value="#request.staffs" var="staff">
									<tr>
										<td>
											<input name="staff_ids" type="checkbox" value="${staff_id}, ${staff_name}"/>
										</td>
										<td>
											${staff_id}
										</td>
										<td>
											${staff_name}
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>

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
