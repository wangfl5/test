package train.Dao.Impl;

import java.util.List;

import train.Dao.interfaces.TrainStaffDao;
import train.domain.TrainStaff;
import exam.Dao.Impl.CommonDaoImpl;

public class TrainStaffDaoImpl extends CommonDaoImpl<TrainStaff> implements TrainStaffDao {

	@Override
	public List<TrainStaff> querytrainStaff(int trainId) {
		List<TrainStaff> list = this.getHibernateTemplate().find("from TrainStaff ts where ts.train_id=?", trainId);
		return list;
	}

	@Override
	public List<TrainStaff> querytrainbyStaffid(int staffId) {
		List<TrainStaff> list = this.getHibernateTemplate().find("from TrainStaff ts where ts.Staff_id=?", staffId);
		return list;
	}

	
}
