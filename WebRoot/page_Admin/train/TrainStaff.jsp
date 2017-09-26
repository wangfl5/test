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
    
    <title>培训员工管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
  </head>
  
  <body>
    <div class="rightinfo">
			<table class="tablelist" width="75%">
				<tr>
					<th>
						参与培训员工ID
					</th>
					<th>
						参与培训员工姓名
					</th>
				</tr>
				<tbody>
					<s:iterator value="#request.trainstaffs" var="trainstaff">
						<tr>
							<td>
								${Staff_id}
							</td>
							<td>
								${Staff_name}
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
  </body>
</html>
