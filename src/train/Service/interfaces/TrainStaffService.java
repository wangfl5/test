package train.Service.interfaces;

import java.util.List;

import train.domain.TrainStaff;
import exam.Service.interfaces.CommonService;

public interface TrainStaffService extends CommonService<TrainStaff>{
	public List<TrainStaff> querytrainStaff(int train_id);
	public List<TrainStaff> querytrainbyStaffid(int Staff_id);
}
