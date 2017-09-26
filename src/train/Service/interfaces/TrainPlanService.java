package train.Service.interfaces;

import exam.Service.interfaces.CommonService;
import train.domain.TrainPlan;
import utils.Page;
import utils.PageResult;

public interface TrainPlanService extends CommonService<TrainPlan>{
	public TrainPlan querytrainStaff(String train_title);

	public PageResult queryTrainBypage(Page page);
}
