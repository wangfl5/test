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
    
    <title>我的调查问卷</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
  </head>
  
  <body>
  <div class="formtitle">
		<span>可参与调查问卷</span>
	</div>
    <div class="rightinfo">
			<table class="tablelist">
				<tr>
					<th>
						问卷名称
					</th>
					<th>
						开始时间
					</th>
					<th>
						截止时间
					</th>
					<th>
						操作
					</th>
				</tr>
				<tbody>
					<s:iterator value="#request.questions" var="question">
						<tr>
							<td >
								${q_name}
							</td>
							<td>
								${q_starttime}
							</td>
							<td>
								${q_endtime}
							</td>
							<td>
								<a href="beginQuestion.action?q_id=${q_id}"
									class="tablelink">参与调查问卷</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
				 
			</table>
		</div>
  </body>
 	<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</html>
