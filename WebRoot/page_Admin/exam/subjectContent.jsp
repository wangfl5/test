<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="exam.domain.Subject"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Subject subject = (Subject)request.getAttribute("subject");
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
		<base href="<%=basePath%>">

		<title>查看试题信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
		function check(){
			var s_content =document.getElementById("s_content").value;
			if(s_content==''){
				alert("题目不为空！");
				return false;
			}
				var s_value =document.getElementById("s_value").value;
			if(s_value==''){
				alert("分值不为空！");
				return false;
			}
			return true;
		}
		</script>
	</head>

	<body>

		<div class="formbody">

			<div class="formtitle">&nbsp; 
				<span>题目信息</span>
			</div>
			<form action="updatesubject.action" method="post" onsubmit="return check()">
				<ul class="forminfo">
					<li>
						<label>
							题目
						</label>
						<input name="s_id" type="hidden" value="${subject.s_id}" />
						<textarea name="s_content" id="s_content" class="textinput">${subject.s_content}</textarea>
					</li>
					<li>
						<label>
							题目分类
						</label>
						<input name="kinds" id="type" type="text" class="dfinput" value="${subject.kinds}"/>
					</li>
					<li>
						<label>
							题型
						</label>
						<input name="type" id="type" type="text" class="dfinput" value="${subject.type}"/>
					</li>
					<li>
						<label>
							分值
						</label>
						<input name="s_value" id="s_value" type="text" class="dfinput"
							style="width:80px" value="${subject.s_value}"/>
					</li>
					<% if(subject.getType().equals("单选题")){
					 %>
					  
					<li>
						<label>
							选项
						</label>
						<input name="s_standard" type="radio" value="A" />
						<input name="s_answer1" type="text" class="dfinput" value="${subject.s_answer1}"/>
					</li>
					<li>
						<label></label>
						<input name="s_standard" type="radio" value="B" />
						<input name="s_answer2" type="text" class="dfinput" value="${subject.s_answer2}"/>
					</li>
					<li>
						<label></label>
						<input name="s_standard" type="radio" value="C" />
						<input name="s_answer3" type="text" class="dfinput" value="${subject.s_answer3}"/>
					</li>
					<li>
						<label></label>
						<input name="s_standard" type="radio" value="D" />
						<input name="s_answer4" type="text" class="dfinput" value="${subject.s_answer4}"/>
					</li>
					<li>
						<label>
							参考答案
						</label>
						<textarea name="s_standards" class="textinput" disabled="disabled">${subject.s_standard}</textarea>
					</li>
					<%}
					else if(subject.getType().equals("多选题")){ %>
					<li>
						<label>
							选项
						</label>
						<input name="s_standard" type="checkbox" value="A" />
						<input name="s_answer1" type="text" class="dfinput" value="${subject.s_answer1}"/>
					</li>
					<li>
						<label></label>
						<input name="s_standard" type="checkbox" value="B" />
						<input name="s_answer2" type="text" class="dfinput" value="${subject.s_answer2}"/>
					</li>
					<li>
						<label></label>
						<input name="s_standard" type="checkbox" value="C" />
						<input name="s_answer3" type="text" class="dfinput" value="${subject.s_answer3}"/>
					</li>
					<li>
						<label></label>
						<input name="s_standard" type="checkbox" value="D" />
						<input name="s_answer4" type="text" class="dfinput" value="${subject.s_answer4}"/>
					</li>
					<li>
						<label>
							参考答案
						</label>
						<textarea name="s_standards" class="textinput" disabled="disabled">${subject.s_standard}</textarea>
					</li>
					<%} 
					else if(subject.getType().equals("填空题")){%>
					<li>
						<label>
							参考答案
						</label>
						<textarea name="s_standard" class="textinput">${subject.s_standard}</textarea>
					</li>
					
					<% }%>
					
					
					<li>
						<label>
							&nbsp;
						</label>
						<input name="" type="submit" class="btn" value="更新保存" />
					</li>
				</ul>
			</form>

		</div>


	</body>
</html>
