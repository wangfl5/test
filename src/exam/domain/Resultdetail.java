package exam.domain;

public class Resultdetail {
	private int rd_id;
	private Result result;
	private int s_id;
	private String answer;
	private int value;
	public int getRd_id() {
		return rd_id;
	}
	public void setRd_id(int rdId) {
		rd_id = rdId;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int sId) {
		s_id = sId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
