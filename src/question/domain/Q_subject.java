package question.domain;

public class Q_subject {
	private int qs_id;
	private String type;
	private String qs_content;
	private String qs_answer1;
	private String qs_answer2;
	private String qs_answer3;
	private String qs_answer4;
	private int answerA;
	private int answerB;
	private int answerC;
	private int answerD;
	private Question question;
	public int getQs_id() {
		return qs_id;
	}
	public void setQs_id(int qsId) {
		qs_id = qsId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQs_content() {
		return qs_content;
	}
	public void setQs_content(String qsContent) {
		qs_content = qsContent;
	}
	public String getQs_answer1() {
		return qs_answer1;
	}
	public void setQs_answer1(String qsAnswer1) {
		qs_answer1 = qsAnswer1;
	}
	public String getQs_answer2() {
		return qs_answer2;
	}
	public void setQs_answer2(String qsAnswer2) {
		qs_answer2 = qsAnswer2;
	}
	public String getQs_answer3() {
		return qs_answer3;
	}
	public void setQs_answer3(String qsAnswer3) {
		qs_answer3 = qsAnswer3;
	}
	public String getQs_answer4() {
		return qs_answer4;
	}
	public void setQs_answer4(String qsAnswer4) {
		qs_answer4 = qsAnswer4;
	}
	
	public int getAnswerA() {
		return answerA;
	}
	public void setAnswerA(int answerA) {
		this.answerA = answerA;
	}
	public int getAnswerB() {
		return answerB;
	}
	public void setAnswerB(int answerB) {
		this.answerB = answerB;
	}
	public int getAnswerC() {
		return answerC;
	}
	public void setAnswerC(int answerC) {
		this.answerC = answerC;
	}
	public int getAnswerD() {
		return answerD;
	}
	public void setAnswerD(int answerD) {
		this.answerD = answerD;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
