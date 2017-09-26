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
		<title></title>
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
				<span>员工信息管理</span>
		</div>
		<div class="rightinfo">
			<table class="tablelist">
				<tr>
					<th>
						用户
					</th>
					<th>
						姓名
					</th>
					<th>
						密码
					</th>
					<th>
						邮箱
					</th>
					<th>
						入职时间
					</th>
					<th>
						职位
					</th>
					<th>
						描述
					</th>
					<th>
						操作
					</th>
				</tr>
				<tbody>
					<s:iterator value="#request.staffs" var="staff">
						<tr>
							<td>
								${staff.staff_id}
							</td>
							<td>
								${staff.staff_name}
							</td>
							<td>
								${staff.password}
							</td>
							<td>
								${staff.email}
							</td>
							<td>
								${staff.worktime}
							</td>
							<td>
								${staff.job}
							</td>
							<td>
								${staff.staff_desc}
							</td>
							<td>
								<a href="queryStaff.action?Staff_id=${staff.staff_id}" 
									class="tablelink">更新</a>
								<a href="deleteStaff.action?Staff_id=${staff.staff_id}"
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
                		<a href="query.action?currentpage=1">首页</a> | 
                		<a href="query.action?currentpage=${page.currentPage - 1}">上一页</a> | 
               		</s:if>
               		<s:else>
               		首页 | 上一页 | 
               		</s:else>
               		<s:if test="#request.page.hasNextPage">
                		<a href="query.action?currentpage=${page.currentPage + 1}">下一页</a> | 
                		<a href="query.action?currentpage=${page.totalPage}">尾页</a>
               		</s:if>
               		<s:else>
               		下一页 | 尾页
               		</s:else> 	
        		</ul>
   		 	</div>
			
			<ul>
			<li>
			</li>
			<li>
					<label>
						&nbsp;
					</label>
					<input type="button" class="btn" value="添加员工" onclick="window.location.href='${pageContext.request.contextPath}/page_Admin/manage/NewStaff.jsp'"/>
			</li>
			</ul>
		</div>
		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>
	</body>
</html>
