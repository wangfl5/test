package exam.action;



import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import exam.Service.interfaces.StaffService;
import exam.domain.Staff;


public class StaffAction extends ActionSupport implements RequestAware,ServletRequestAware{
	private HttpSession session;
	private Map<String,Object> request;
	private int login_id;
	private String password;
	private StaffService staffservice;
	private String checkCode;

	public String getCheckCode() {
		return checkCode;
	}


	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}


	public int getLogin_id() {
		return login_id;
	}


	public void setLogin_id(int loginId) {
		login_id = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StaffService getStaffservice() {
		return staffservice;
	}
	public void setStaffservice(StaffService staffservice) {
		this.staffservice = staffservice;
	}	
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.session=req.getSession();
		
	}
	
	
	/**
	 * 登录校验
	 * @return
	 * @throws IOException 
	 */
	public String getStaffbycondition() throws IOException{
		HttpSession session = ServletActionContext.getRequest().getSession(); 
		Writer writer=ServletActionContext.getResponse().getWriter();
        String checkCode2 = (String)session.getAttribute("checkCode");
        if(checkCode.equals(checkCode2))
        {
        	Staff staff = staffservice.getEntryByID(login_id);
        	//System.out.println(staff);
    		if(null!=staff && staff.getPassword().equals(password)){
    			session.setAttribute("login_id", login_id);
    			if("true".equals(staff.getIsAdmin())){
    				writer.write("1");//跳转管理员界面
    				//return SUCCESS;
    			}else{
    				writer.write("2");//跳转员工界面
    			}
    			//return "staff";
    		}else{
    			writer.write("3");//用户名，密码不匹配
    		}
        }
        else{
        	writer.write("0");//验证码不正确
        	//return LOGIN;
        }
		writer.flush();
		writer.close();
		return null;
	}

	
	
	


	



	
}
