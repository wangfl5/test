<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>调查问卷结果管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/echarts.min.js"></script>
	<script type="text/javascript">
		function count(id){
			var temp = "qs_id="+id;
			window.showModalDialog("countStatistic.action?"+temp,window,"dialogWidth:600px;dialogHeight:400px;status:no");
		}
	</script>
  </head>
  
  <body>
    <div class="rightinfo">
			<s:iterator value="#request.subjects" var="subject" status="sta">
			<table class="tablelist">
					<tr>
						<td colspan="4">
							<strong>第${sta.index + 1}题&nbsp;${subject.qs_content}</strong>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>A．</strong>${subject.qs_answer1}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>B．</strong>${subject.qs_answer2}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>C．</strong>${subject.qs_answer3}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>D．</strong>${subject.qs_answer4}
						</td>
					</tr>
					<tr>
						<td>
							<input type="button" class="btn" onclick="count(${subject.qs_id})" value="统计结果">
							
						</td>
					</tr>
				</table>
				</s:iterator>
		</div>
		
  </body>
 	
</html>
