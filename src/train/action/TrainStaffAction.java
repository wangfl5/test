package train.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

import exam.Service.interfaces.StaffService;
import train.Service.interfaces.TrainPlanService;
import train.Service.interfaces.TrainStaffService;
import train.domain.TrainPlan;
import train.domain.TrainStaff;

public class TrainStaffAction extends ActionSupport implements RequestAware{
	private Map<String,Object> request;
	private TrainStaffService trainstaffservice;
	private TrainPlanService trainplanservice;
	private StaffService staffservice;
	
	private int train_id;
	private String train_title;
	private Date train_time;
	private String train_place;
	private String Staff_ids;
	private int set_id;
	
	private String name;
	private File train_file;//File类型，名字对应表单的上传输入域
	private String train_fileFileName;//上传文件的文件名
	private String train_fileContentType;//上传文件的MIME类型
	private InputStream inputStream;//定义一个输入流
	private String fileName;
	public TrainPlanService getTrainplanservice() {
		return trainplanservice;
	}
	public void setTrainplanservice(TrainPlanService trainplanservice) {
		this.trainplanservice = trainplanservice;
	}
	public StaffService getStaffservice() {
		return staffservice;
	}
	public void setStaffservice(StaffService staffservice) {
		this.staffservice = staffservice;
	}
	
	
	public int getSet_id() {
		return set_id;
	}
	public void setSet_id(int setId) {
		set_id = setId;
	}
	public int getTrain_id() {
		return train_id;
	}
	public void setTrain_id(int trainId) {
		train_id = trainId;
	}
	public String getTrain_title() {
		return train_title;
	}
	public void setTrain_title(String trainTitle) {
		train_title = trainTitle;
	}
	public Date getTrain_time() {
		return train_time;
	}
	public void setTrain_time(Date trainTime) {
		train_time = trainTime;
	}
	public String getTrain_place() {
		return train_place;
	}
	public void setTrain_place(String trainPlace) {
		train_place = trainPlace;
	}
	public String getStaff_ids() {
		return Staff_ids;
	}
	public void setStaff_ids(String staffIds) {
		Staff_ids = staffIds;
	}
	
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public TrainStaffService getTrainstaffservice() {
		return trainstaffservice;
	}
	public void setTrainstaffservice(TrainStaffService trainstaffservice) {
		this.trainstaffservice = trainstaffservice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public File getTrain_file() {
		return train_file;
	}
	public void setTrain_file(File trainFile) {
		train_file = trainFile;
	}
	
	
	public String getTrain_fileFileName() {
		return train_fileFileName;
	}
	public void setTrain_fileFileName(String trainFileFileName) {
		train_fileFileName = trainFileFileName;
	}
	public String getTrain_fileContentType() {
		return train_fileContentType;
	}
	public void setTrain_fileContentType(String trainFileContentType) {
		train_fileContentType = trainFileContentType;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 查询培训员工
	 * @return
	 */
	public String querytrainStaff(){
		List<TrainStaff> list = trainstaffservice.querytrainStaff(train_id);
		request.put("trainstaffs", list);
		return SUCCESS;
	}
	
	/**
	 * 新建培训计划
	 * @return
	 */
	public String Newtrain(){
		TrainPlan tp = new TrainPlan();
		tp.setTrain_title(train_title);
		tp.setTrain_time(train_time);
		tp.setTrain_place(train_place);
		tp.setSet_id(set_id);
		if(upload()){
			tp.setFile(train_fileFileName);
		}
		trainplanservice.saveEntry(tp);
		
		int id = trainplanservice.querytrainStaff(train_title).getTrain_id();
		String[] staffid_copy = Staff_ids.split(", ");
		int[] staffid = new int[staffid_copy.length/2];
		String[] staffname = new String[staffid.length];
		for(int temp=0;temp<staffid_copy.length;temp++){
			if(temp%2==0){
				staffid[temp/2] = Integer.parseInt(staffid_copy[temp]);
			}
			else
				staffname[temp/2] = staffid_copy[temp];
		}
		//批量保存
		for(int temp=0;temp<staffid.length;temp++){
			TrainStaff ts = new TrainStaff();
			ts.setTrain_id(id);
			ts.setStaff_id(staffid[temp]);
			ts.setStaff_name(staffname[temp]);
			trainstaffservice.saveEntry(ts);
		}
		return SUCCESS;
	}
	
	/**
	 * 上传培训材料
	 * @return
	 */
	private boolean upload() {
		//完成上传
		ServletContext sc = ServletActionContext.getServletContext();
		String directory = sc.getRealPath("/files");//得到存放文件的真实目录
		//构建目标文件
		File target = new File(directory, train_fileFileName);
		//写文件
		try {
			FileUtils.copyFile(train_file, target);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 下载培训材料
	 * @return
	 */
	public String downloadfile(){
		try {
			train_fileFileName=new String(train_fileFileName.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String realPath = ServletActionContext.getServletContext().getRealPath("/files/"+train_fileFileName);
		fileName = FilenameUtils.getName(realPath);
		try {
			inputStream = new FileInputStream(realPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	
	/**
	 * 查询我的培训信息
	 * @return
	 */
	public String querymytrain(){
		List<TrainStaff> list = trainstaffservice.querytrainbyStaffid(Integer.parseInt(Staff_ids));
		List<TrainPlan> list2 = new ArrayList<TrainPlan>();
		for(int temp=0;temp<list.size();temp++){
			TrainPlan tp =trainplanservice.getEntryByID(list.get(temp).getTrain_id());
			list2.add(tp);
		}
		request.put("trainplans", list2);
		return SUCCESS;
	}
}
