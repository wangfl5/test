package question.domain;

import java.util.Date;
import java.util.Set;

public class Question {
	private int q_id;
	private String q_name;
	private Date q_starttime; 
	private Date q_endtime;
	private Set<Q_subject> q_subject;
	private String state;
	private int set_id;
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int qId) {
		q_id = qId;
	}
	public String getQ_name() {
		return q_name;
	}
	public void setQ_name(String qName) {
		q_name = qName;
	}
	public Date getQ_starttime() {
		return q_starttime;
	}
	public void setQ_starttime(Date qStarttime) {
		q_starttime = qStarttime;
	}
	public Date getQ_endtime() {
		return q_endtime;
	}
	public void setQ_endtime(Date qEndtime) {
		q_endtime = qEndtime;
	}
	public Set<Q_subject> getQ_subject() {
		return q_subject;
	}
	public void setQ_subject(Set<Q_subject> qSubject) {
		q_subject = qSubject;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getSet_id() {
		return set_id;
	}
	public void setSet_id(int setId) {
		set_id = setId;
	}
	
}
