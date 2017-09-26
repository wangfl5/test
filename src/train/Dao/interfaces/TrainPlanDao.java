package train.Dao.interfaces;

import java.util.List;

import exam.Dao.interfaces.CommonDao;
import train.domain.TrainPlan;
import utils.Page;

public interface TrainPlanDao extends CommonDao<TrainPlan>{

	public TrainPlan querytrainStaff(String train_title);
	public List<TrainPlan> queryTrainBypage(Page page);
}
