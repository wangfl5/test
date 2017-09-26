package exam.domain;

import java.io.Serializable;
import java.util.Date;

public class Staff implements Serializable {
	private int staff_id;
	private String password;
	private String staff_name;
	private Date worktime;
	private String email;
	private String job;
	private String staff_desc;
	private String isAdmin;
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
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public Date getWorktime() {
		return worktime;
	}
	public void setWorktime(Date worktime) {
		this.worktime = worktime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
}
