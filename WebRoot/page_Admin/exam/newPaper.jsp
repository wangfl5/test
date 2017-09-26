<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
		<base href="<%=basePath%>">

		<title>新增试卷</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/datepicker/WdatePicker.js"></script>
		<script type="text/javascript">
		function values(){
			
			var rusult=0;
           	var check_array=document.getElementsByName("subject_value");      	
           	for(var i=0;i<check_array.length;i++)
           	{
               if(check_array[i].checked==true)
               {    
                  rusult=parseInt(rusult)+parseInt(check_array[i].value);
               }
          	}
        	document.getElementById("p_totalvalue").value=rusult;
        	
     	}
		function checks(){
			var p_name =document.getElementById("p_name").value;
			if(p_name==''){
				alert("试卷名字不为空！");
				return false;
			}
			var p_time =document.getElementById("p_time").value;
			if(p_time==''){
				alert("考试截止时间不为空！");
				return false;
			}
			var p_totalvalue =document.getElementById("p_totalvalue").value;
			var p_passvalue =document.getElementById("p_passvalue").value;
			if(parseInt(p_totalvalue)<=parseInt(p_passvalue)){
				alert("及格分数不能比总分高！");
				return false;
			}
			var check_array2=document.getElementsByName("subject_value");
           	var subject_ids=document.getElementsByName("subject_ids");
           	
           	for(var i=0;i<check_array2.length;i++)
           	{
               if(check_array2[i].checked==false)
               {  
               	  subject_ids[i].value="0";
               }
          	}
			return true;
		}
		</script>
	</head>

	<body>
		<div class="formbody" >
			<div class="formtitle">
				<span>试卷基本信息</span>
			</div>
			<form action="savePaper.action" method="post"
				onsubmit="return checks()">
				<ul class="forminfo">
					<li>
						试卷名称
						<b>*</b> &nbsp;
						<input name="p_name" id="p_name" type="text" class="dfinput" />
						&nbsp;&nbsp;&nbsp; 考试截止时间
						<b>*</b>&nbsp;
						<input name="p_time" id="p_time" type="text" class="dfinput"
							style="width: 180px"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
					</li>
					<li>
						试卷总分
						<b>*</b> &nbsp;
						<input name="p_totalvalue" id="p_totalvalue" type="text" class="dfinput" readonly="readonly"
							style="width: 150px" />
						&nbsp;&nbsp;&nbsp; 及格线
						<b>*</b> &nbsp;
						<input name="p_passvalue" id="p_passvalue" type="text" class="dfinput"
							style="width: 150px" />
						<input name="set_id" type="hidden" value="${session.login_id}"/>
					</li>
				</ul>

				<div class="formtitle" >
					<span>题库选题</span>
				</div>
				<ul>
					<li>
						<div style="width:70%; height:260px; overflow:scroll;">
						<table class="tablelist">
							<tr>
								<th width="50">
								</th>
								<th width="400">
									题目
								</th>
								<th>
									题目分类
								</th>
								<th>
									题目类型
								</th>
								<th>
									题目分值
								</th>
							</tr>
							<tbody>
								<s:iterator value="#request.subjects" var="subject">
									<tr>
										<td>
											<input name="subject_ids" type="hidden" value="${s_id}"/>
											<input name="subject_value" type="checkbox" value="${s_value}" onclick="values();"/>
											
										</td>
										<td width="400">
											${subject.s_content}
										</td>
										<td>
											${subject.kinds}
										</td>
										<td>
											${subject.type}
										</td>
										<td>
											${subject.s_value}
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
						</div>
					</li>
					<li>
						<label>
							&nbsp;&nbsp;&nbsp;
						</label>
						<input type="submit" class="btn" value="确认保存" />
					</li>
				</ul>
			</form>
		</div>
	</body>
	<script type="text/javascript">
			$('.tablelist2 tbody tr:odd').addClass('odd');
	</script>
</html>
