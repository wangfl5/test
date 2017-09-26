<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtm1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script language="javascript">
function check(){
		var id =document.getElementById("ids").value;
		var checkCode=document.getElementById("checkCode").value;
		var psw =document.getElementById("passwords").value;
		var flag=true;
		if(id==''){
			alert("用户Id不为空！");
			flag=false;
		}
		else{	
			if(psw==''){
				alert("用户密码不为空！");
				flag=false;
			}
		}
		if(flag){
			$.post("login.action", { checkCode:checkCode, password: psw,login_id: id},
  			 	function(data){
    			if(data=="0"){
    				alert("输入的验证码不正确");
    			}
    			if(data=="1"){
    				window.location.href="main.jsp";
    			}
    			if(data=="2"){
    				window.location.href="page_Staff/Staffmain.html";
    			}
    			if(data=="3"){
    				alert("用户名，密码不匹配");
    			}
   			}, "json");
		}
}
</script>
</head>

<body>
<div class="main-login">
	<div class="login-logo">
	
	</div>
	<div class="login-content">	
    <div class="login-info">
	<span class="user">&nbsp;</span>
	<input name="login_id" id="ids" type="text" value="" class="login-input"/>
	</div>
    <div class="login-info">
	<span class="pwd">&nbsp;</span>
	<input name="password" id="passwords" type="password" value="" class="login-input"/>
	</div>
    <div class="login-oper">
		<input name="checkCode" id="checkCode" class="login-input" style="width: 250px" value="验证码" onclick="JavaScript:this.value=''"/>
        <img src="createImageAction.action" onclick="this.src='createImageAction.action?'+ Math.random()" title="点击图片刷新验证码"/>
	</div>
    <div class="login-oper" align="center">
		<input name="" type="button" value="登 录" class="login-btn" onclick="check();"/>
	</div>
    </div>
    
</div>   
</body>

</html>
