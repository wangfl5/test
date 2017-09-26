package exam.domain;

import java.util.Date;
import java.util.Set;

public class Paper {
	private int p_id;
	private String p_name;
	private Date p_time; 
	private int p_passvalue;
	private int p_totalvalue;
	private int set_id;
	private Set<Paperdetail> paperdetails;
	private String state;
	
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int pId) {
		p_id = pId;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String pName) {
		p_name = pName;
	}
	public Date getP_time() {
		return p_time;
	}
	public void setP_time(Date pTime) {
		p_time = pTime;
	}
	public int getP_passvalue() {
		return p_passvalue;
	}
	public void setP_passvalue(int pPassvalue) {
		p_passvalue = pPassvalue;
	}
	public int getP_totalvalue() {
		return p_totalvalue;
	}
	public void setP_totalvalue(int pTotalvalue) {
		p_totalvalue = pTotalvalue;
	}
	public void setPaperdetails(Set<Paperdetail> paperdetails) {
		this.paperdetails = paperdetails;
	}
	public Set<Paperdetail> getPaperdetails() {
		return paperdetails;
	}
	public int getSet_id() {
		return set_id;
	}
	public void setSet_id(int setId) {
		set_id = setId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
