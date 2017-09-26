package train.action;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

import train.Service.interfaces.TrainPlanService;
import train.domain.TrainPlan;
import utils.Page;
import utils.PageResult;
import utils.PageUtil;

public class TrainPlanAction extends ActionSupport implements RequestAware{
	private Map<String,Object> request;
	private TrainPlanService trainplanservice;
	private int currentpage;  //分页使用
	private int train_id;
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public int getTrain_id() {
		return train_id;
	}

	public void setTrain_id(int trainId) {
		train_id = trainId;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	

	public void setTrainplanservice(TrainPlanService trainplanservice) {
		this.trainplanservice = trainplanservice;
	}

	public TrainPlanService getTrainplanservice() {
		return trainplanservice;
	}
	
	public String queryTrainAll(){
		List<TrainPlan> trainplans = trainplanservice.findAllEntry();
		request.put("trainplans", trainplans);
		return SUCCESS;
	}

	/**
	 * 查询培训计划并分页展示
	 * @return
	 */
	
	public String queryTrainBypage(){
		Page page = PageUtil.getPage(8, currentpage);
		PageResult pageresult = trainplanservice.queryTrainBypage(page);
		List<TrainPlan> trainplans = pageresult.getList();
		request.put("trainplans", trainplans);
		request.put("page", pageresult.getPage());
		return SUCCESS;
	}
	
	
	public String deleteTrain(){
		trainplanservice.deleteEntry(train_id);
		return SUCCESS;
	}
	
	
}
