package exam.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.RequestAware;

import question.domain.Question;

import utils.Page;
import utils.PageResult;
import utils.PageUtil;

import com.opensymphony.xwork2.ActionSupport;

import exam.Service.interfaces.PaperService;
import exam.Service.interfaces.PaperdetailService;
import exam.Service.interfaces.ResultService;
import exam.Service.interfaces.ResultdetailService;
import exam.Service.interfaces.SubjectService;
import exam.domain.Paper;
import exam.domain.Paperdetail;
import exam.domain.Result;
import exam.domain.Subject;

public class PaperAction extends ActionSupport implements RequestAware{
	private Map<String,Object> request;
	private PaperService paperservice;
	private PaperdetailService paperdetailservice;
	private SubjectService subjectservice;
	private ResultService resultservice;
	private int staff_id;
	private int p_id;
	private String p_name;
	private Date p_time;
	private int p_passvalue;
	private int p_totalvalue;
	private String subject_ids;
	private int currentpage; //分页使用
	private String exam_name;
	private Date exam_start;
	private Date exam_end;
	private int set_id;
	public void setPaperservice(PaperService paperservice) {
		this.paperservice = paperservice;
	}

	public PaperService getPaperservice() {
		return paperservice;
	}
	
	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public int getP_id() {
		return p_id;
	}

	public void setP_id(int pId) {
		p_id = pId;
	}

	public PaperdetailService getPaperdetailservice() {
		return paperdetailservice;
	}

	public void setPaperdetailservice(PaperdetailService paperdetailservice) {
		this.paperdetailservice = paperdetailservice;
	}

	public SubjectService getSubjectservice() {
		return subjectservice;
	}

	public void setSubjectservice(SubjectService subjectservice) {
		this.subjectservice = subjectservice;
	}

	public ResultService getResultservice() {
		return resultservice;
	}

	public void setResultservice(ResultService resultservice) {
		this.resultservice = resultservice;
	}

	public String getSubject_ids() {
		return subject_ids;
	}

	public void setSubject_ids(String subjectIds) {
		subject_ids = subjectIds;
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

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public String getExam_name() {
		return exam_name;
	}

	public void setExam_name(String examName) {
		exam_name = examName;
	}

	public Date getExam_start() {
		return exam_start;
	}

	public void setExam_start(Date examStart) {
		exam_start = examStart;
	}

	public Date getExam_end() {
		return exam_end;
	}

	public void setExam_end(Date examEnd) {
		exam_end = examEnd;
	}

	public int getSet_id() {
		return set_id;
	}

	public void setSet_id(int setId) {
		set_id = setId;
	}

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staffId) {
		staff_id = staffId;
	}


	/**
	 * 查询所有试卷信息
	 * @return
	 */
	public String queryallpaper(){
		String exam_names=exam_name;
		if(exam_name!=null){
			try {
				exam_names = new String(exam_name.getBytes("ISO8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		List<Paper> list = paperservice.queryPaperBy(exam_names,exam_start,exam_end);
		request.put("papers", list);
		return SUCCESS;
	}
	
	/**
	 * 查询我的考试
	 * @return
	 */
	public String querymypaper(){
		Date date = new Date();
		List<Paper> list = paperservice.findQuestionbyDate(date);
		List<Paper> mylist = new ArrayList<Paper>();
		for(int temp=0;temp<list.size();temp++){
			Paper copy = list.get(temp);
			if(0==resultservice.getEntryByCondition(copy.getP_id(), staff_id)){
				mylist.add(copy);
			}
		}
		request.put("papers", mylist);
		return SUCCESS;
	}
	/**
	 * 分页查询试卷
	 * @return
	 */
	public String queryPaperBypage(){
		String exam_names=exam_name;
		if(exam_name!=null){
			try {
				exam_names = new String(exam_name.getBytes("ISO8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		Date date = new Date();
		Page page = PageUtil.getPage(8, currentpage);
		PageResult pageresult = paperservice.queryPaperBypage(page,exam_names,exam_start,exam_end);
		List<Paper> papers = pageresult.getList();
		for(int i=0;i<papers.size();i++){
			if(papers.get(i).getP_time().before(date)){
				papers.get(i).setState("已结束");
			}
			else{
				papers.get(i).setState("");
			}
		}
		request.put("papers", papers);
		request.put("page", pageresult.getPage());
		
		return SUCCESS;
	}
	
	
	/**
	 * 查询试卷题目信息
	 * @return
	 */
	public String query_paper_content(){
		Paper paper =  paperservice.getEntryByID(p_id);
		List<Subject> subjects = new ArrayList<Subject>();
		List<Subject> blanksubject = new ArrayList<Subject>();
		Set<Paperdetail> set = paper.getPaperdetails();
		Iterator<Paperdetail> it = set.iterator();
		while(it.hasNext()){
			Paperdetail p = it.next();
			Subject temp = subjectservice.getEntryByID(p.getS_id());
			if("填空题".equals(temp.getType())){
				blanksubject.add(temp);
			}
			else{
				subjects.add(temp);
			}
		}
		request.put("paper", paper);
		request.put("subjects", subjects);
		request.put("blanksubjects", blanksubject);
		return SUCCESS;
	}
	/**
	 * 转到新建试卷页面
	 * @return
	 */
	public String newPaper(){
		List<Subject> list = subjectservice.findAllEntry();
		request.put("subjects", list);
		return SUCCESS;
	}
	/**
	 * 新建试卷
	 * @return
	 */
	public String savePaper(){
		
		Paper paper = new Paper();
		paper.setP_name(p_name);
		paper.setP_passvalue(p_passvalue);
		paper.setP_time(p_time);
		paper.setP_totalvalue(p_totalvalue);
		paper.setSet_id(set_id);
		Set<Paperdetail> paperdetails = new HashSet<Paperdetail>();
		String[] id_copy = subject_ids.split(", ");
		int[] subject_id = new int[id_copy.length];
		for(int temp=0;temp<id_copy.length;temp++){
			subject_id[temp] = Integer.parseInt(id_copy[temp]);
		}
		for(int s_id:subject_id){
			if(s_id==0){
				continue;
			}
			Paperdetail paperdetail = new Paperdetail();
			paperdetail.setS_id(s_id);
			
			paperdetails.add(paperdetail);

		}
		paper.setPaperdetails(paperdetails);
		paperservice.saveEntry(paper);
		return SUCCESS;
	}
	
	/**
	 * 删除试卷
	 * @return
	 */
	public String deletePaper(){
		paperservice.deleteEntry(p_id);
		List<Result> result = resultservice.findByPaper(p_id);
		for(int i=0;i<result.size();i++){
			resultservice.deleteEntry(result.get(i).getR_id());
		}
		return SUCCESS;
	}
	
	/**
	 * 开始考试
	 * @return
	 */
	public String beginExam(){
		Paper paper =  paperservice.getEntryByID(p_id);
		List<Subject> singlesubjects = new ArrayList<Subject>();
		List<Subject> multisubjects = new ArrayList<Subject>();
		List<Subject> blanksubjects = new ArrayList<Subject>();
		Set<Paperdetail> set = paper.getPaperdetails();
		Iterator<Paperdetail> it = set.iterator();
		while(it.hasNext()){
			Subject temp = subjectservice.getEntryByID(it.next().getS_id());
			if("单选题".equals(temp.getType())){
				singlesubjects.add(temp);
			}
			else if("多选题".equals(temp.getType())){
				multisubjects.add(temp);
			}
			else if("填空题".equals(temp.getType())){
				blanksubjects.add(temp);
			}
		}
		request.put("paper", paper);
		request.put("singlesubjects", singlesubjects);
		request.put("multisubjects", multisubjects);
		request.put("blanksubjects", blanksubjects);
		return SUCCESS;
	}
}
