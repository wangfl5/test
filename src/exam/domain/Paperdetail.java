package exam.domain;

public class Paperdetail {
	private int paperdetail_id;
	private int s_id;
	private Paper paper;
	public int getPaperdetail_id() {
		return paperdetail_id;
	}
	public void setPaperdetail_id(int paperdetailId) {
		paperdetail_id = paperdetailId;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int sId) {
		s_id = sId;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	
	
}
