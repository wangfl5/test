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
    
    <title>My JSP 'Mytrain.jsp' starting page</title>
    
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
		<span>我的培训</span>
	</div>
    <div class="rightinfo">
			<table class="tablelist">
				<tr>
					<th>
						培训主题
					</th>
					<th>
						培训时间
					</th>
					<th >
						培训地点
					</th>
					<th>
						培训相关文档
					</th>
				</tr>
				<tbody>
					<s:iterator value="#request.trainplans" var="trainplan">
						<tr>
							<td >
								${train_title}
							</td>
							<td>
								${train_time}
							</td>
							<td>
								${train_place}
							</td>
							<td>
								<a href="downloadfile.action?train_fileFileName=${file}" 
									class="tablelink">${file}</a> 
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
  </body>
</html>
