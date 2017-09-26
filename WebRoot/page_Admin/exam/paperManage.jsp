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
    
    <title>试卷管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/datepicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function query(){
			var exam_name = document.getElementById("exam_name").value;
			var exam_start = document.getElementById("exam_start").value;
			var exam_end = document.getElementById("exam_end").value;
			if((exam_start!=""&&exam_end=="")||(exam_start==""&&exam_end!="")){
				alert("开始时间和结束时间都需要输入！");
			}
			else{
				document.location.href=encodeURI("queryPaperbyCondition.action?exam_name="+exam_name+"&exam_start="+exam_start+"&exam_end="+exam_end);
			}
		}
	</script>
  </head>
  
  <body>
  	<div class="formbody">
  	<div class="formtitle">
		<span>试卷信息管理</span>
	</div>
	<div id="usual1" class="usual"> 
  	<ul class="seachform1" style="float:left">
  		<li>
  			<label>考试名称</label>
  			<input id="exam_name" type="text" class="scinput1" />
  		</li>
  		<li>
  			<label>截止时间</label>
  			<input id="exam_start" type="text" class="scinput1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
  		</li>
    	<li>
    		<label>一</label>
    		<input id="exam_end" type="text" class="scinput1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
    	</li> 
    	<li class="sarchbtn"><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询" onclick="query()"/></li> 
  	</ul>
  	
  	</div>
  	</div>
    <div class="rightinfo">
			<table class="tablelist">
				<tr>
					<th>
						试卷名称
					</th>
					<th>
						截止时间
					</th>
					<th>
						试卷总分
					</th>
					<th>
						及格线
					</th>
					<th>
						创建人
					</th>
					<th>
						状态
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
								${set_id}
							</td>
							<td>
								${state}
							</td>
							<td>
								<a href="query_paper_content.action?p_id=${p_id}"
									class="tablelink">查看内容</a>
								<a href="deletePaper.action?p_id=${p_id}"
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
                		<a href="queryAllPaper.action?currentpage=1">首页</a> | 
                		<a href="queryAllPaper.action?currentpage=${page.currentPage - 1}">上一页</a> | 
               		</s:if>
               		<s:else>
               		首页 | 上一页 | 
               		</s:else>
               		<s:if test="#request.page.hasNextPage">
                		<a href="queryAllPaper.action?currentpage=${page.currentPage + 1}">下一页</a> | 
                		<a href="queryAllPaper.action?currentpage=${page.totalPage}">尾页</a>
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
