package train.Service.Impl;

import java.util.List;

import exam.Service.Impl.CommonServiceImpl;
import train.Dao.interfaces.TrainPlanDao;
import train.Service.interfaces.TrainPlanService;
import train.domain.TrainPlan;
import utils.Page;
import utils.PageResult;

public class TrainPlanServiceImpl extends CommonServiceImpl<TrainPlan> implements TrainPlanService {
	private TrainPlanDao trainplan;
	public TrainPlanDao getTrainplan() {
		return trainplan;
	}
	public void setTrainplan(TrainPlanDao trainplan) {
		this.trainplan = trainplan;
	}
	
	@Override
	public TrainPlan querytrainStaff(String train_title) {
		return trainplan.querytrainStaff(train_title);
		
	}
	@Override
	public PageResult queryTrainBypage(Page page) {
		page = utils.PageUtil.createPage(page.getEveryPage(), trainplan.findAllEntry().size(),  page.getCurrentPage());
		List<TrainPlan> list = trainplan.queryTrainBypage(page);
		PageResult pageResult = new PageResult(page, list);
		return pageResult;
	}
	
	
}
