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
    
    <title>我的考试</title>
    
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
		<span>我的考试</span>
	</div>
    <div class="rightinfo">
			<table class="tablelist">
				<tr>
					<th>
						试卷名称
					</th>
					<th>
						考试截止时间
					</th>
					<th>
						试卷总分
					</th>
					<th>
						及格线
					</th>
					<th>
						操作
					</th>
				</tr>
				<tbody>
					<s:iterator value="#request.papers" var="paper">
						<tr>
							<td >
								${p_name}
							</td>
							<td>
								${p_time}
							</td>
							<td>
								${p_totalvalue}
							</td>
							<td>
								${p_passvalue}
							</td>
							<td>
								<a href="beginExam.action?p_id=${p_id}"
									class="tablelink">开始答题</a>
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
