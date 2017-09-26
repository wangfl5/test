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

		<title>开始问卷</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<form action="saveQ_Result.action" method="post" >
			<table class="tablelist" border="0" align="center">
				<tr>
					<td>
						<div align="center">
							<input type="hidden" name="q_id" value="${question.q_id}">
							<input type="hidden" name="staff_id" value="${session.login_id}">
							试卷:${question.q_name}
						</div>
					</td>
					<td>
						<div align="center">
							问卷截止时间：${question.q_starttime}
						</div>
					</td>
				</tr>
				<tr>
					<th colspan="4">
						单选题
					</th>
				</tr>

				<s:iterator value="#request.subjects" var="subject"
					status="sta">
					<tr>
						<td colspan="4">
							<strong>第${sta.index + 1}题&nbsp;${subject.qs_content}</strong>&nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input type="hidden" name="qs_ids" value="${subject.qs_id}" />
							<input name="standard${sta.index}" type="radio" value="A" />
							<strong>A．</strong>${subject.qs_answer1}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input name="standard${sta.index}" type="radio" value="B" />
							<strong>B．</strong>${subject.qs_answer2}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input name="standard${sta.index}" type="radio" value="C" />
							<strong>C．</strong>${subject.qs_answer3}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input name="standard${sta.index}" type="radio" value="D" />
							<strong>D．</strong>${subject.qs_answer4}
						</td>
					</tr>
				</s:iterator>
				
			</table>
			<table align="center">
				<tr>
					<td colspan="4" align="center">
						<input name="" type="submit" class="btn" value="确认提交" />
					</td>
				</tr>
			</table>
			</form>
		</body>
</html>
