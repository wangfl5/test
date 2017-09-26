package utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{  
  

	@Override  
    protected String doIntercept(ActionInvocation invoker) throws Exception {  
		HttpSession s = ServletActionContext.getRequest().getSession();
		Object login_id = s.getAttribute("login_id");
		if(null==login_id){
			return "login";
		}
		return invoker.invoke();
    }

  
}  
