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

		<title>答题详情</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/style.css" rel="stylesheet" type="text/css" />

	</head>

	<body>
			<table class="tablelist" border="0" align="center">
				<tr>
					<th colspan="4">
						单选题
					</th>
				</tr>

				<s:iterator value="#request.singlesubjects" var="singlesubject"
					status="sta">

					<tr>
						<td colspan="4">
							<strong>第${sta.index + 1}题&nbsp;${singlesubject.s_content}</strong>&nbsp;(${singlesubject.s_value}分)
						</td>
					</tr>
					<tr>
						<td colspan="4">
							
							<strong>A．</strong>${singlesubject.s_answer1}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							
							<strong>B．</strong>${singlesubject.s_answer2}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							
							<strong>C．</strong>${singlesubject.s_answer3}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							
							<strong>D．</strong>${singlesubject.s_answer4}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>我的答案：</strong>${singlesubject.staff_answer}
							<strong>参考答案：</strong>${singlesubject.s_standard}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>得分：</strong>${singlesubject.staff_value}
						</td>
					</tr>
				</s:iterator>
				<tr>
					<th colspan="4">
						多选题
					</th>
				</tr>
				<s:iterator value="#request.multisubjects" var="multisubject" status="sta">
					<tr>
						<td colspan="4">
							<strong>第${sta.index + 1}题&nbsp;${multisubject.s_content}</strong>&nbsp;(${multisubject.s_value}分)
						</td>
					</tr>
					<tr>
						<td colspan="4">
							
							<strong>A．</strong>${multisubject.s_answer1}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							
							<strong>B．</strong>${multisubject.s_answer2}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							
							<strong>C．</strong>${multisubject.s_answer3}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							
							<strong>D．</strong>${multisubject.s_answer4}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>我的答案：</strong>${multisubject.staff_answer}
							<strong>参考答案：</strong>${multisubject.s_standard}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>得分：</strong>${multisubject.staff_value}
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
							<strong>第${sta.index + 1}题</strong> &nbsp;(${blanksubject.s_value}分)
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>${blanksubject.s_content}</strong>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>我的答案：</strong>${blanksubject.staff_answer}
							
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>参考答案：</strong>${blanksubject.s_standard}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>得分：</strong>${blanksubject.staff_value}
						</td>
					</tr>
				</s:iterator>
			</table>
		
		</body>
</html>
