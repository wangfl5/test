package exam.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import utils.Page;
import utils.PageResult;
import utils.PageUtil;

import com.opensymphony.xwork2.ActionSupport;

import exam.Service.interfaces.StaffService;
import exam.domain.Staff;
import exam.domain.Subject;

public class StaffManageAction extends ActionSupport implements RequestAware {
	private Map<String,Object> request;
	private int staff_id;
	private String staff_password;
	private String staff_name;
	private String email;
	private Date worktime;
	private String job;
	private String staff_desc;
	private String isAdmin;
	private StaffService staffservice;
	private int currentpage; //分页使用
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staffId) {
		staff_id = staffId;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staffName) {
		staff_name = staffName;
	}
	public String getStaff_desc() {
		return staff_desc;
	}
	public void setStaff_desc(String staffDesc) {
		staff_desc = staffDesc;
	}
	public StaffService getStaffservice() {
		return staffservice;
	}
	public void setStaffservice(StaffService staffservice) {
		this.staffservice = staffservice;
	}
	public void setStaff_password(String staff_password) {
		this.staff_password = staff_password;
	}
	public String getStaff_password() {
		return staff_password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getWorktime() {
		return worktime;
	}
	public void setWorktime(Date worktime) {
		this.worktime = worktime;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	/**
	 * 查询全部员工
	 * @return
	 */
	public String queryStaffAll(){
		List<Staff> staffs = staffservice.findAllEntry();
		request.put("staffs", staffs);
		return SUCCESS;
	}
	
	/**
	 * 分页查询员工信息
	 * @return
	 */
	public String queryStaffBypage(){
		Page page = PageUtil.getPage(8, currentpage);
		PageResult pageresult = staffservice.queryStaffBypage(page);
		List<Staff> staffs = pageresult.getList();
		request.put("staffs", staffs);
		request.put("page", pageresult.getPage());
		
		return SUCCESS;
	}
	
	
	/**
	 * 删除单个员工
	 * @return
	 */
	public String deleteStaff(){
		staffservice.deleteEntry(staff_id);
		return SUCCESS;
	}
	
	/**
	 * 查询单个员工
	 * @return
	 */
	public String queryStaff(){
		Staff staff = staffservice.getEntryByID(staff_id);
		request.put("staff", staff);
		return SUCCESS;
	}
	/**
	 * 更新单个员工
	 * @return
	 */
	public String updateStaff(){
		Staff staff = staffservice.getEntryByID(staff_id);
		staff.setPassword(staff_password);
		staff.setStaff_name(staff_name);
		staff.setEmail(email);
		staff.setWorktime(worktime);
		staff.setJob(job);
		if(isAdmin!=null){
			staff.setIsAdmin(isAdmin);
		}
		staff.setStaff_desc(staff_desc);
		staffservice.updateEntry(staff);
		return SUCCESS;
	}
	/**
	 * 新增员工
	 * @return
	 */
	public String saveStaff(){
		if(null!=staffservice.getEntryByID(staff_id)){
			return ERROR;
		}
		Staff staff = new Staff();
		staff.setStaff_id(staff_id);
		staff.setPassword(staff_password);
		staff.setStaff_name(staff_name);
		staff.setEmail(email);
		staff.setWorktime(worktime);
		staff.setJob(job);
		staff.setStaff_desc(staff_desc);
		staff.setIsAdmin("false");
		staffservice.saveEntry(staff);
		return SUCCESS;
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	public String updatePsw(){
		Staff staff = staffservice.getEntryByID(staff_id);
		staff.setPassword(staff_password);
		staffservice.updateEntry(staff);
		request.put("staff", staff);
		return SUCCESS;
	}
}
