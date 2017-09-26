package train.Dao.interfaces;

import java.util.List;

import train.domain.TrainStaff;
import exam.Dao.interfaces.CommonDao;

public interface TrainStaffDao extends CommonDao<TrainStaff>{
	public List<TrainStaff> querytrainStaff(int train_id);

	public List<TrainStaff> querytrainbyStaffid(int staffId);
}
