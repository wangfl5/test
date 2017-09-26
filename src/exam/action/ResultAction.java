package exam.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import utils.Page;
import utils.PageResult;
import utils.PageUtil;

import com.opensymphony.xwork2.ActionSupport;

import exam.Service.interfaces.PaperService;
import exam.Service.interfaces.ResultService;
import exam.Service.interfaces.ResultdetailService;
import exam.Service.interfaces.StaffService;
import exam.Service.interfaces.SubjectService;
import exam.domain.Paper;
import exam.domain.Paperdetail;
import exam.domain.Result;
import exam.domain.Resultdetail;
import exam.domain.Staff;
import exam.domain.Subject;

public class ResultAction extends ActionSupport implements RequestAware{
	private ResultService resultservice;
	private StaffService staffservice;
	private PaperService paperservice;
	private SubjectService subjectservice;
	private ResultdetailService resultdetailservice;
	private int r_id;
	private int p_id;
	private int staff_id;
	private String multi_standard;
	private String blank_standard;
	private String single_ids;
	private String multi_ids;
	private String blank_ids;
	private Map<String,Object> request;
	private int currentpage; //分页使用
	public ResultService getResultservice() {
		return resultservice;
	}
	public void setResultservice(ResultService resultservice) {
		this.resultservice = resultservice;
	}
	
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public StaffService getStaffservice() {
		return staffservice;
	}
	public void setStaffservice(StaffService staffservice) {
		this.staffservice = staffservice;
	}
	public PaperService getPaperservice() {
		return paperservice;
	}
	public void setPaperservice(PaperService paperservice) {
		this.paperservice = paperservice;
	}
	
	public SubjectService getSubjectservice() {
		return subjectservice;
	}
	public void setSubjectservice(SubjectService subjectservice) {
		this.subjectservice = subjectservice;
	}
	
	public ResultdetailService getResultdetailservice() {
		return resultdetailservice;
	}
	public void setResultdetailservice(ResultdetailService resultdetailservice) {
		this.resultdetailservice = resultdetailservice;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int rId) {
		r_id = rId;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int pId) {
		p_id = pId;
	}
	
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staffId) {
		staff_id = staffId;
	}
	public String getMulti_standard() {
		return multi_standard;
	}
	public void setMulti_standard(String multiStandard) {
		multi_standard = multiStandard;
	}
	
	public String getSingle_ids() {
		return single_ids;
	}
	public void setSingle_ids(String singleIds) {
		single_ids = singleIds;
	}
	public String getMulti_ids() {
		return multi_ids;
	}
	public void setMulti_ids(String multiIds) {
		multi_ids = multiIds;
	}
	public String getBlank_ids() {
		return blank_ids;
	}
	public void setBlank_ids(String blankIds) {
		blank_ids = blankIds;
	}
	
	
	public String getBlank_standard() {
		return blank_standard;
	}
	public void setBlank_standard(String blankStandard) {
		blank_standard = blankStandard;
	}
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	/**
	 * 查询所有考试结果
	 * @return
	 */
	public String queryAllResult(){
		List<Result> results  = resultservice.findAllEntry();
		for(Result result:results){
			String staff_name = staffservice.getEntryByID(result.getStaff_id()).getStaff_name();
			String p_name = paperservice.getEntryByID(result.getP_id()).getP_name();
			result.setStaff_name(staff_name);
			result.setP_name(p_name);
		}
		request.put("results", results);
		return SUCCESS;
	}
	
	/**
	 * 分页查询考试结果
	 * @return
	 */
	public String queryResultBypage(){
		Page page = PageUtil.getPage(8, currentpage);
		PageResult pageresult = resultservice.queryResultBypage(page);
		List<Result> results = pageresult.getList();
		for(Result result:results){
			String staff_name = staffservice.getEntryByID(result.getStaff_id()).getStaff_name();
			String p_name = paperservice.getEntryByID(result.getP_id()).getP_name();
			result.setStaff_name(staff_name);
			result.setP_name(p_name);
		}
		request.put("results", results);
		request.put("page", pageresult.getPage());
		
		return SUCCESS;
	}
	
	/**
	 * 删除考试结果
	 * @return
	 */
	public String deleteResult(){
		resultservice.deleteEntry(r_id);
		return SUCCESS;
	}
	
	/**
	 * 保存考试结果
	 * @return
	 */
	public String saveResult(){
		Result result = new Result();
		Paper paper = paperservice.getEntryByID(p_id);
		result.setP_id(p_id);
		result.setStaff_id(staff_id);
		result.setPassvalue(paper.getP_passvalue());
		result.setResultdetail(setResultdetail(p_id));
		result.setTotalvalue(totalvalue(result.getResultdetail()));
		resultservice.saveEntry(result);
		return SUCCESS;
	}
	
	/**
	 * 员工查看考试结果
	 * @return
	 */
	public String queryMyResult(){
		List<Result> results  = resultservice.findbystaffId(staff_id);
		for(Result result:results){
			String staff_name = staffservice.getEntryByID(result.getStaff_id()).getStaff_name();
			String p_name = paperservice.getEntryByID(result.getP_id()).getP_name();
			result.setStaff_name(staff_name);
			result.setP_name(p_name);
		}
		request.put("results", results);
		return SUCCESS;
	}
	
	/**
	 * 查看答题详情
	 * @return
	 */
	public String query_result_detail(){
		Result result = resultservice.getEntryByID(r_id);
		Iterator<Resultdetail> resultdetails  = result.getResultdetail().iterator();
		
		Paper paper = paperservice.getEntryByID(result.getP_id());
		List<Subject> singlesubjects = new ArrayList<Subject>();
		List<Subject> multisubjects = new ArrayList<Subject>();
		List<Subject> blanksubjects = new ArrayList<Subject>();
		Set<Paperdetail> set = paper.getPaperdetails();
		Iterator<Paperdetail> it = set.iterator();
		while(it.hasNext()){
			Subject temp = subjectservice.getEntryByID(it.next().getS_id());
			Resultdetail resultdetail = resultdetails.next();
			temp.setStaff_answer(resultdetail.getAnswer());
			temp.setStaff_value(resultdetail.getValue());
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
		
		request.put("singlesubjects", singlesubjects);
		request.put("multisubjects", multisubjects);
		request.put("blanksubjects", blanksubjects);
		return SUCCESS;
	}
	
	
	
	/**
	 * 设置答题详情
	 * @return
	 */
	public Set<Resultdetail> setResultdetail(int p_id){
		Set<Resultdetail> resultdetails = new HashSet<Resultdetail>();
		//s_id
		Paper p = paperservice.getEntryByID(p_id);
		Set<Paperdetail> paperdetail = p.getPaperdetails();
		Iterator<Paperdetail> pd = paperdetail.iterator();
		List<Integer> list = new ArrayList<Integer>(); 
		while(pd.hasNext()){
			list.add(pd.next().getS_id());
		}
		if(single_ids!=null){
			int[] single_id = change(single_ids.split(", "),list);
			HttpServletRequest requests = ServletActionContext.getRequest();
			List<String> singleAnswers = new ArrayList<String>();
			for (int i = 0; i<single_id.length; i++) {
				String answer = requests.getParameter("single_standard" + i);
				singleAnswers.add(answer);
			}
			if (single_id.length != 0) {
				int[] singlevalues = new int[single_id.length];
				for (int temp = 0; temp < singlevalues.length; temp++) {
					singlevalues[temp] = judge(single_id[temp], singleAnswers
							.get(temp));
					Resultdetail resultdetail = new Resultdetail();
					resultdetail.setS_id(single_id[temp]);
					resultdetail.setAnswer(singleAnswers.get(temp));
					resultdetail.setValue(singlevalues[temp]);
					resultdetails.add(resultdetail);
				}
			}
		}
		if(multi_ids!=null){
			int[] multi_id = change(multi_ids.split(", "),list);
			String[] multiAnswers = multi_standard.replace(", ", "").split("&&");
			if (multi_id.length != 0) {
				int[] multivalues = new int[multi_id.length];
				for (int temp = 0; temp < multivalues.length; temp++) {
					multivalues[temp] = judge(multi_id[temp],
							multiAnswers[temp]);
					Resultdetail resultdetail = new Resultdetail();
					resultdetail.setS_id(multi_id[temp]);
					resultdetail.setAnswer(multiAnswers[temp + 1]);
					resultdetail.setValue(multivalues[temp]);
					resultdetails.add(resultdetail);
				}
			}
		}
		if(blank_ids!=null){
			int[] blank_id = change(blank_ids.split(", "),list);
			String[] blankAnswers = blank_standard.split(", ");
			if (blank_id.length != 0) {
				int[] blankvalues = new int[blank_id.length];
				for (int temp = 0; temp < blankvalues.length; temp++) {
					blankvalues[temp] = judge(blank_id[temp],
							blankAnswers[temp]);
					Resultdetail resultdetail = new Resultdetail();
					resultdetail.setS_id(blank_id[temp]);
					resultdetail.setAnswer(blankAnswers[temp]);
					resultdetail.setValue(blankvalues[temp]);
					resultdetails.add(resultdetail);
				}
			}
		}
		return resultdetails;
		
	}
	
	/**
	 * 改变id类型为int
	 * @param stringvalue
	 * @param list 
	 * @return
	 */
	public int[] change(String[] stringvalue, List<Integer> list){
		int[] intvalue = new int[stringvalue.length];
		for(int temp=0;temp<stringvalue.length;temp++){
			int id =Integer.parseInt(stringvalue[temp]);
			for(int i=0;i<list.size();i++){
			if(id==list.get(i)){
				intvalue[temp] = id;
			}
			}
		}
		return intvalue;
	}
	
	/**
	 * 获取每题得分
	 * @param s_id
	 * @param answer
	 * @return
	 */
	public int judge(int s_id,String answer){
		Subject subject= subjectservice.getEntryByID(s_id);
		if("填空题".equals(subject.getType())){
			String[] copys = subject.getS_standard().split(" ");
			String[] answers = answer.split(" ");
			double count=0;
			for(int temp=0;temp<answers.length;temp++){
				if(copys[temp].equals(answers[temp])){
					count++;
				}
			}
			double temp2 = count/copys.length;
			return (int) (temp2*subject.getS_value());
		}
		if(answer.equals(subject.getS_standard())){
			return subject.getS_value();
		}
		return 0;
	}
	
	/**
	 * 获取总得分
	 * @param resultdetails
	 * @return
	 */
	public int totalvalue(Set<Resultdetail> resultdetails){
		int totalvalue=0;
		Iterator<Resultdetail> it = resultdetails.iterator();
		while(it.hasNext()){
			totalvalue+=it.next().getValue();
		}
		return totalvalue;
	}
}
