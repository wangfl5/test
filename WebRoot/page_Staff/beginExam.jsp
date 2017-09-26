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

		<title>开始考试</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	var ksTime; //定义考试时间以分钟计算
	ksTime = 30;//设置时间 这里设置为0.1代表是6秒
	//if (readCookie("ss") == "") {
	setCookie("ss", new Date(), ksTime / 60);
	//}
	function sT() {
		var tti = new Date();
		var lt = parseInt((tti - new Date(readCookie("ss"))) / 1000)
		if ((ksTime * 60 - lt) < 0) {
			setCookie("ss", new Date(), 0);
			alert("考试时间到!\n即将提交试卷!");
			document.forms[0].submit();
		} else {
			lm = Math.floor(lt / 60);
			ls = lt % 60;
			allY = ksTime * 60 - lt;
			ym = Math.floor(allY / 60);
			ys = allY % 60;
			document.getElementById("tTime").innerHTML = "考试已经开始了 " + lm + " 分 "
					+ ls + " 秒 " + ",剩余 " + ym + " 分 " + ys + " 秒";
			var ttt = setTimeout("sT()", 1000);
		}
	}
	function readCookie(name) {
		var cookieValue = "";
		var search = name + "=";
		if (document.cookie.length > 0) {
			offset = document.cookie.indexOf(search);
			if (offset != -1) {
				offset += search.length;
				end = document.cookie.indexOf(";", offset);
				if (end == -1)
					end = document.cookie.length;
				cookieValue = document.cookie.substring(offset, end)
			}
		}
		return cookieValue;
	}
	function setCookie(name, value, hours) {
		var expire = "";
		if (hours != null) {
			expire = new Date((new Date()).getTime() + hours * 3600000);
			expire = "; expires=" + expire.toGMTString();
		}
		document.cookie = name + "=" + value + expire;
	}
	function keydown(){
	  if(event.keyCode==13){
		event.keyCode=0;
		event.returnValue=false;
		alert("当前设置不允许使用回车键");
	  }
	  if(event.keyCode==116){
		event.keyCode=0;
		event.returnValue=false;
		alert("当前设置不允许使用F5刷新键");
	  }
	  if((event.altKey)&&((window.event.keyCode==37)||(window.event.keyCode==39))){
		event.returnValue=false;
		alert("当前设置不允许使用Alt+方向键←或方向键→");
	  }    
    }
    //屏蔽右键
    function document.oncontextmenu()          
	{          
        return false;          
    }        
</script>
	</head>

	<body onload="sT()" onkeydown="keydown()">
		<form id="testform" action="saveResult.action" method="post">
			<table class="tablelist" border="0" align="center">
				<tr>
					<td>
						<div align="center">
							<input type="hidden" name="p_id" value="${paper.p_id}">
							<input type="hidden" name="staff_id" value="${session.login_id}">
							试卷:${paper.p_name}
						</div>
					</td>
					<td>
						<div align="center">
							考试截止时间：${paper.p_time}
						</div>
					</td>
					<td>
						<div align="center">
							总分 ：${paper.p_totalvalue}
						</div>
					</td>
					<td>
						<div align="center">
							及格线 ：${paper.p_passvalue}
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<strong><div id="tTime" style="color: #F00" align="center"></div></strong>
					</td>
				</tr>
				<tr>
					<th colspan="4">
						单选题
					</th>
				</tr>

				<s:iterator value="#request.singlesubjects" var="singlesubject"
					status="sta">

					<tr>
						<td colspan="4">
							<strong>第${sta.index + 1}题&nbsp;${singlesubject.s_content}</strong>&nbsp;(${singlesubject.s_value}分)
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input type="hidden" name="single_ids" value="${singlesubject.s_id}" />
							<input name="single_standard${sta.index}" type="radio" value="A" />
							<strong>A．</strong>${singlesubject.s_answer1}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input name="single_standard${sta.index}" type="radio" value="B" />
							<strong>B．</strong>${singlesubject.s_answer2}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input name="single_standard${sta.index}" type="radio" value="C" />
							<strong>C．</strong>${singlesubject.s_answer3}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input name="single_standard${sta.index}" type="radio" value="D" />
							<strong>D．</strong>${singlesubject.s_answer4}
						</td>
					</tr>
				</s:iterator>
				<tr>
					<th colspan="4">
						多选题
					</th>
				</tr>
				<s:iterator value="#request.multisubjects" var="multisubject" status="sta">
					<tr>
						<td colspan="4">
							<strong>第${sta.index + 1}题&nbsp;${multisubject.s_content}</strong>&nbsp;(${multisubject.s_value}分)
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input type="hidden" name="multi_ids" value="${multisubject.s_id}" />
							<input type="hidden" name="multi_standard" value="&&" />
							<input name="multi_standard" type="checkbox" value="A" />
							<strong>A．</strong>${multisubject.s_answer1}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input name="multi_standard" type="checkbox" value="B" />
							<strong>B．</strong>${multisubject.s_answer2}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input name="multi_standard" type="checkbox" value="C" />
							<strong>C．</strong>${multisubject.s_answer3}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input name="multi_standard" type="checkbox" value="D" />
							<strong>D．</strong>${multisubject.s_answer4}
						</td>
					</tr>
				</s:iterator>
				<tr>
					<th colspan="4">
						填空题
					</th>
				</tr>
				<s:iterator value="#request.blanksubjects" var="blanksubject" status="sta">
					<tr>
						<td colspan="4">
							<strong>第${sta.index + 1}题&nbsp;</strong>&nbsp;(${blanksubject.s_value}分)
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong>${blanksubject.s_content}</strong>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input type="hidden" name="blank_ids" value="${blanksubject.s_id}" />
							
							<input name="blank_standard" type="text" style="width: 650px" class="dfinput"/><strong>注：答案之间用空格隔开</strong>
							
						</td>
					</tr>
				</s:iterator>
			</table>
			<table align="center">
				<tr>
					<td colspan="4" align="center">
						<input name="" type="submit" class="btn" value="确认提交" />
					</td>
				</tr>
			</table>
			</form>
		</body>
</html>
