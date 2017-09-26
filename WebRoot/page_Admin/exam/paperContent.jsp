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

		<title>查看试卷信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
			<table class="tablelist" border="0" align="center" >
				<tr>
					<td>
						<div align="center">
							试卷:${paper.p_name}
						</div>
					</td>
					<td>
						<div align="center">
							考试时间：${paper.p_time}
						</div>
					</td>
					<td>
						<div align="center">
							总分 ：${paper.p_totalvalue}
						</div>
					</td>
					<td>
						<div align="center">
							及格线 ：${paper.p_passvalue}
						</div>
					</td>
				</tr>
				<tr>
					<th colspan="4">
						选择题
					</th>
				</tr>
				
				<s:iterator value="#request.subjects" var="subject" status="sta">
					<tr>
						<td colspan="4">
							<strong>第${sta.index + 1}题&nbsp;${subject.s_content}</strong>&nbsp;(${subject.s_value}分)
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>A．</strong>${subject.s_answer1}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>B．</strong>${subject.s_answer2}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>C．</strong>${subject.s_answer3}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>D．</strong>${subject.s_answer4}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>参考答案：</strong>${subject.s_standard}
						</td>
					</tr>
					
				</s:iterator>
				<tr>
					<th colspan="4">
						填空题
					</th>
				</tr>
				<s:iterator value="#request.blanksubjects" var="blanksubject" status="sta">
					<tr>
						<td colspan="4">
							<strong>第${sta.index + 1}题&nbsp;</strong>&nbsp;(${blanksubject.s_value}分)
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>${blanksubject.s_content}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>参考答案：</strong>${blanksubject.s_standard}
						</td>
					</tr>
					
				</s:iterator>
			</table>

	</body>
</html>
