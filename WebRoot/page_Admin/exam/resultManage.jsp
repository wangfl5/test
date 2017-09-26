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
    
    <title>考试结果管理</title>
    
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
		<span>考试结果查询</span>
	</div>
    <div class="rightinfo">
			<table class="tablelist">
				<tr>
					<th>
						试卷名称
					</th>
					<th>
						考生ID
					</th>
					<th>
						考生姓名
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
								${staff_id}
							</td>
							<td>
								${staff_name}
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
								<a href="deleteResult.action?r_id=${r_id}"
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
                		<a href="queryAllResult.action?currentpage=1">首页</a> | 
                		<a href="queryAllResult.action?currentpage=${page.currentPage - 1}">上一页</a> | 
               		</s:if>
               		<s:else>
               		首页 | 上一页 | 
               		</s:else>
               		<s:if test="#request.page.hasNextPage">
                		<a href="queryAllResult.action?currentpage=${page.currentPage + 1}">下一页</a> | 
                		<a href="queryAllResult.action?currentpage=${page.totalPage}">尾页</a>
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
