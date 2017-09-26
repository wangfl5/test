package exam.domain;

import java.util.Set;

public class Result {
	private int r_id;
	private int staff_id;
	private String staff_name;
	private int p_id;
	private String p_name;
	private int passvalue;
	private int totalvalue;
	private Set<Resultdetail> resultdetail;
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int rId) {
		r_id = rId;
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
	public int getPassvalue() {
		return passvalue;
	}
	public void setPassvalue(int passvalue) {
		this.passvalue = passvalue;
	}
	public int getTotalvalue() {
		return totalvalue;
	}
	public void setTotalvalue(int totalvalue) {
		this.totalvalue = totalvalue;
	}
	public Set<Resultdetail> getResultdetail() {
		return resultdetail;
	}
	public void setResultdetail(Set<Resultdetail> resultdetail) {
		this.resultdetail = resultdetail;
	}
	
}
