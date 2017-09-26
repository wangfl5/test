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
    
    <title>培训计划管理</title>
    
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
				<span>培训计划管理</span>
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
						培训材料
					</th>
					<th>
						创建人
					</th>
					<th>
						操作
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
							<td>
								${set_id}
							</td>
							<td>
								<a href="query_train_staff.action?train_id=${train_id}"
									class="tablelink">查看人员</a>
								<a href="deleteTrain.action?train_id=${train_id}"
									class="tablelink">删除</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
				 
			</table>
			<div class="pagin">
    			<div class="message">共<i class="blue">&nbsp;${page.totalCount}&nbsp;</i>条记录，当前显示第&nbsp;<i class="blue">${page.currentPage}&nbsp;</i>页</div>
        		<ul class="paginList">
        			<s:if test="#request.page.hasPrePage">
                		<a href="querytrain.action?currentpage=1">首页</a> | 
                		<a href="querytrain.action?currentpage=${page.currentPage - 1}">上一页</a> | 
               		</s:if>
               		<s:else>
               		首页 | 上一页 | 
               		</s:else>
               		<s:if test="#request.page.hasNextPage">
                		<a href="querytrain.action?currentpage=${page.currentPage + 1}">下一页</a> | 
                		<a href="querytrain.action?currentpage=${page.totalPage}">尾页</a>
               		</s:if>
               		<s:else>
               		下一页 | 尾页
               		</s:else> 	
        		</ul>
   		 	</div>
		</div>
  </body>
  	<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</html>
