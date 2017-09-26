package exam.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import utils.Page;
import utils.PageResult;
import utils.PageUtil;

import com.opensymphony.xwork2.ActionSupport;

import exam.Service.interfaces.SubjectService;
import exam.domain.Subject;

public class SubjectAction extends ActionSupport implements RequestAware{
	private Map<String,Object> request;
	private SubjectService subjectservice;
	private int s_id;
	private String type;
	private String kinds;
	private String s_content;
	private int s_value;
	private String s_standard;
	private String s_answer1;
	private String s_answer2;
	private String s_answer3;
	private String s_answer4;
	private int currentpage; //分页使用
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

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int sId) {
		s_id = sId;
	}
	public String getS_content() {
		return s_content;
	}

	public void setS_content(String sContent) {
		s_content = sContent;
	}

	

	public int getS_value() {
		return s_value;
	}

	public void setS_value(int sValue) {
		s_value = sValue;
	}

	public String getS_standard() {
		return s_standard;
	}

	public void setS_standard(String sStandard) {
		s_standard = sStandard;
	}

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
	public SubjectService getSubjectservice() {
		return subjectservice;
	}

	public void setSubjectservice(SubjectService subjectservice) {
		this.subjectservice = subjectservice;
	}
	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	/**
	 * 查询所有题目
	 * @return
	 */
	public String querySubjectAll(){
		List<Subject> list = subjectservice.findAllEntry();
		request.put("subjects", list);
		return SUCCESS;
	}
	
	/**
	 * 按分页查询题目信息
	 * @return
	 */
	public String querySubjectBypage(){
		Page page = PageUtil.getPage(8, currentpage);
		PageResult pageresult = subjectservice.querySubjectBypage(page);
		List<Subject> subjects = pageresult.getList();
		request.put("subjects", subjects);
		request.put("page", pageresult.getPage());
		
		return SUCCESS;
	}
	/**
	 * 保存单选题
	 * @return
	 */
	public String savesingle(){
		Subject subject = new Subject();
		subject.setType("单选题");
		subject.setKinds(kinds);
		subject.setS_content(s_content);
		subject.setS_value(s_value);
		subject.setS_answer1(s_answer1);
		subject.setS_answer2(s_answer2);
		subject.setS_answer3(s_answer3);
		subject.setS_answer4(s_answer4);
		subject.setS_standard(s_standard);
		subjectservice.saveEntry(subject);
		return SUCCESS;
	}
	
	/**
	 * 保存多选题
	 * @return
	 */
	public String savemulti(){
		Subject subject = new Subject();
		subject.setType("多选题");
		subject.setKinds(kinds);
		subject.setS_content(s_content);
		subject.setS_value(s_value);
		subject.setS_answer1(s_answer1);
		subject.setS_answer2(s_answer2);
		subject.setS_answer3(s_answer3);
		subject.setS_answer4(s_answer4);
//		
//		String[] temp = s_standard.split(", ");//拆分并组装标准答案
//		StringBuffer sb2 = new StringBuffer();
//		for(String string:temp){
//			sb2.append(string);
//		}
//		subject.setS_standard(sb2.toString());
		s_standard = s_standard.replaceAll(", ", "");
		subject.setS_standard(s_standard);
		subjectservice.saveEntry(subject);
		return SUCCESS;
	}
	
	/**
	 * 保存填空题
	 * @return
	 */
	public String saveblank(){
		Subject subject = new Subject();
		subject.setType("填空题");
		subject.setKinds(kinds);
		subject.setS_content(s_content);
		subject.setS_value(s_value);
		subject.setS_standard(s_standard);
		subjectservice.saveEntry(subject);
		return SUCCESS;
	}
	/**
	 * 查看题目详细内容
	 * @return
	 */
	public String query_subject_content(){
		Subject subject = subjectservice.getEntryByID(s_id);
		request.put("subject", subject);
		return SUCCESS;
	}
	
	/**
	 * 删除题目
	 * @return
	 */
	public String deletesubject(){
		subjectservice.deleteEntry(s_id);
		return SUCCESS;
	}
	
	/**
	 * 更新题目信息
	 * @return
	 */
	public String updatesubject(){
		//更新选择题
		Subject subject =subjectservice.getEntryByID(s_id);
		subject.setS_content(s_content);
		subject.setKinds(kinds);
		if (!type.equals("填空题")) {
			subject.setS_answer1(s_answer1);
			subject.setS_answer2(s_answer2);
			subject.setS_answer3(s_answer3);
			subject.setS_answer4(s_answer4);
		}
		if (s_standard != null) {
			if (!type.equals("多选题")) {
				subject.setS_standard(s_standard);
			} else {
				s_standard = s_standard.replaceAll(", ", "");
				subject.setS_standard(s_standard);
			}
		}
		subject.setS_value(s_value);
		subjectservice.updateEntry(subject);
		return SUCCESS;
	}
	
}
