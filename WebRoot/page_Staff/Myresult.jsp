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
    
    <title>我的考试结果</title>
    
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
		<span>我的考试结果</span>
	</div>
    <div class="rightinfo">
			<table class="tablelist">
				<tr>
					<th>
						试卷名称
					</th>
					<th>
						及格线
					</th>
					<th>
						得分
					</th>
					<th>
						操作
					</th>
				</tr>
				<tbody>
					<s:iterator value="#request.results" var="result">
						<tr>
							<td >
								${p_name}
							</td>
							<td>
								${passvalue}
							</td>
							<td>
								${totalvalue}
							</td>
							<td>
								<a href="query_result_detail.action?r_id=${r_id}"
									class="tablelink">查看答题情况</a>
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
