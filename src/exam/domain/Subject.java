package exam.domain;

public class Subject {
	private int s_id;
	private String type;
	private String kinds;
	private String s_content;
	private String s_answer1;
	private String s_answer2;
	private String s_answer3;
	private String s_answer4;
	private String s_standard;
	private String staff_answer;
	private int staff_value;
	private int s_value;
	public String getS_answer1() {
		return s_answer1;
	}
	public void setS_answer1(String sAnswer1) {
		s_answer1 = sAnswer1;
	}
	public String getS_answer2() {
		return s_answer2;
	}
	public void setS_answer2(String sAnswer2) {
		s_answer2 = sAnswer2;
	}
	public String getS_answer3() {
		return s_answer3;
	}
	public void setS_answer3(String sAnswer3) {
		s_answer3 = sAnswer3;
	}
	public String getS_answer4() {
		return s_answer4;
	}
	public void setS_answer4(String sAnswer4) {
		s_answer4 = sAnswer4;
	}
	
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int sId) {
		s_id = sId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	public String getS_content() {
		return s_content;
	}
	public void setS_content(String sContent) {
		s_content = sContent;
	}
	public String getS_standard() {
		return s_standard;
	}
	public void setS_standard(String sStandard) {
		s_standard = sStandard;
	}
	public int getS_value() {
		return s_value;
	}
	public void setS_value(int sValue) {
		s_value = sValue;
	}
	public String getStaff_answer() {
		return staff_answer;
	}
	public void setStaff_answer(String staffAnswer) {
		staff_answer = staffAnswer;
	}
	public int getStaff_value() {
		return staff_value;
	}
	public void setStaff_value(int staffValue) {
		staff_value = staffValue;
	}
	
	
}
