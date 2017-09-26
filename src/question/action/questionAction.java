package question.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import question.Service.interfaces.Q_StatisticService;
import question.Service.interfaces.Q_subjectService;
import question.Service.interfaces.questionService;
import question.domain.Q_Statistic;
import question.domain.Q_subject;
import question.domain.Question;
import utils.Page;
import utils.PageResult;
import utils.PageUtil;

import com.opensymphony.xwork2.ActionSupport;

import exam.domain.Paper;

public class questionAction extends ActionSupport implements RequestAware{
	private questionService questionservice;
	private Q_StatisticService q_statisticservice;
	private Q_subjectService q_subjectservice;
	private Map<String,Object> request;
	private int q_id;
	private int qs_id;
	private int staff_id;
	private String q_name;
	private Date q_starttime;
	private Date q_endtime;
	private int set_id;
	private String s_content;
	private String s_answer1;
	private String s_answer2;
	private String s_answer3;
	private String s_answer4;
	private int currentpage; //分页使用
	public questionService getQuestionservice() {
		return questionservice;
	}

	public void setQuestionservice(questionService questionservice) {
		this.questionservice = questionservice;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
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

	public String getS_content() {
		return s_content;
	}

	public void setS_content(String sContent) {
		s_content = sContent;
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
	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staffId) {
		staff_id = staffId;
	}

	public Q_StatisticService getQ_statisticservice() {
		return q_statisticservice;
	}

	public void setQ_statisticservice(Q_StatisticService qStatisticservice) {
		q_statisticservice = qStatisticservice;
	}

	public Q_subjectService getQ_subjectservice() {
		return q_subjectservice;
	}

	public void setQ_subjectservice(Q_subjectService qSubjectservice) {
		q_subjectservice = qSubjectservice;
	}

	public int getQs_id() {
		return qs_id;
	}

	public void setQs_id(int qsId) {
		qs_id = qsId;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getCurrentpage() {
		return currentpage;
	}
	public int getSet_id() {
		return set_id;
	}

	public void setSet_id(int setId) {
		set_id = setId;
	}

	/**
	 * 问卷管理
	 * @return
	 */
	public String queryAllquestion(){
		List<Question> questions = questionservice.findAllEntry();
		Date date = new Date();
		for(int temp =0;temp<questions.size();temp++){
			if(questions.get(temp).getQ_endtime().before(date)){
				questions.get(temp).setState("过期");
			}
			else{
				questions.get(temp).setState("进行中");
			}
		}
		request.put("questions",questions);
		return SUCCESS;
	}
	
	/**
	 * 分页查询问卷信息
	 * @return
	 */
	public String queryQuestionBypage(){
		Page page = PageUtil.getPage(8, currentpage);
		PageResult pageresult = questionservice.queryQuestionBypage(page);
		List<Question> questions = pageresult.getList();
		Date date = new Date();
		for(int temp =0;temp<questions.size();temp++){
			if(questions.get(temp).getQ_endtime().before(date)){
				questions.get(temp).setState("过期");
			}
			else{
				questions.get(temp).setState("进行中");
			}
		}
		request.put("questions", questions);
		request.put("page", pageresult.getPage());
		
		return SUCCESS;
	}
	
	/**
	 * 新增问卷
	 * @return
	 */
	public String saveQuestion(){
		Question question = new Question();
		question.setQ_name(q_name);
		question.setQ_starttime(q_starttime);
		question.setQ_endtime(q_endtime);
		question.setSet_id(set_id);
		Set<Q_subject> subjects = new HashSet<Q_subject>();
		String[] s_contentcopy = s_content.split(", ");
		String[] s_answer1copy = s_answer1.split(", ");
		String[] s_answer2copy = s_answer2.split(", ");
		String[] s_answer3copy = s_answer3.split(", ");
		String[] s_answer4copy = s_answer4.split(", ");
		for(int temp=0;temp<s_contentcopy.length;temp++){
			Q_subject subject = new Q_subject();
			subject.setQs_content(s_contentcopy[temp]);
			subject.setQs_answer1(s_answer1copy[temp]);
			subject.setQs_answer2(s_answer2copy[temp]);
			subject.setQs_answer3(s_answer3copy[temp]);
			subject.setQs_answer4(s_answer4copy[temp]);
			subjects.add(subject);
		}
		question.setQ_subject(subjects);
		questionservice.saveEntry(question);
		return SUCCESS;
	}
	
	/**
	 * 查询问卷内容
	 * @return
	 */
	public String query_question_content(){
		Question question = questionservice.getEntryByID(q_id);
		Set<Q_subject> q_subject = question.getQ_subject();
		request.put("subjects", q_subject);
		return SUCCESS;
	}
	
	/**
	 * 查询我的问卷
	 * @return
	 */
	public String querymyquestion(){
		Date date = new Date();
		List<Question> questions = questionservice.findQuestionbyDate(date);
		List<Question> myquestion = new ArrayList<Question>();
		for(int temp=0;temp<questions.size();temp++){
			Question copy = questions.get(temp);
			if(0==q_statisticservice.getEntryByCondition(copy.getQ_id(), staff_id)){
				myquestion.add(copy);
			}
		}
		request.put("questions", myquestion);
		return SUCCESS;
	}
	
	/**
	 * 开始问卷
	 * @return
	 */
	public String beginQuestion(){
		Question question = questionservice.getEntryByID(q_id);
		Set<Q_subject> q_subject = question.getQ_subject();
		request.put("question", question);
		request.put("subjects", q_subject);
		return SUCCESS;
	}
	/**
	 * 保存问卷结果
	 * @return
	 */
	public String saveQ_Result(){
		
		//更新题目表数据
		Question question = questionservice.getEntryByID(q_id);
		Set<Q_subject> q_subject = question.getQ_subject();
		Iterator<Q_subject> iterator = q_subject.iterator();
		HttpServletRequest requests = ServletActionContext.getRequest();
		for (int i = 0; i<q_subject.size(); i++) {
			String answer = requests.getParameter("standard" + i);
			Q_subject subject = iterator.next();
			if("A".equals(answer)){
				subject.setAnswerA(subject.getAnswerA()+1);
			}
			else if("B".equals(answer)){
				subject.setAnswerB(subject.getAnswerB()+1);
			}
			else if("C".equals(answer)){
				subject.setAnswerC(subject.getAnswerC()+1);
			}
			else if("D".equals(answer)){
				subject.setAnswerD(subject.getAnswerD()+1);
			}
			q_subjectservice.updateEntry(subject);
		}
		
		//记录员工参与此次问卷调查
		Q_Statistic q_statistic = new Q_Statistic();
		q_statistic.setQ_id(q_id);
		q_statistic.setStaff_id(staff_id);
		q_statisticservice.saveEntry(q_statistic);
		return SUCCESS;
	}
	
	/**
	 * 统计结果查看
	 * @return
	 */
	public String countStatistic(){
		Q_subject q = q_subjectservice.getEntryByID(qs_id);
		request.put("subject", q);
		return SUCCESS;
	}
	
	/**
	 * 删除调查问卷
	 * @return
	 */
	public String deleteQuestion(){
		questionservice.deleteEntry(q_id);
		return SUCCESS;
	}
	
}
