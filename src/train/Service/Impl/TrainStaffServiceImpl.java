package train.Service.Impl;

import java.util.List;

import exam.Service.Impl.CommonServiceImpl;

import train.Dao.interfaces.TrainStaffDao;
import train.Service.interfaces.TrainStaffService;
import train.domain.TrainStaff;

public class TrainStaffServiceImpl extends CommonServiceImpl<TrainStaff> implements TrainStaffService {
	private TrainStaffDao trainstaffdao;
	public TrainStaffDao getTrainstaffdao() {
		return trainstaffdao;
	}
	public void setTrainstaffdao(TrainStaffDao trainstaffdao) {
		this.trainstaffdao = trainstaffdao;
	}
	@Override
	public List<TrainStaff> querytrainStaff(int trainId) {
		return trainstaffdao.querytrainStaff(trainId);
	}
	@Override
	public List<TrainStaff> querytrainbyStaffid(int Staff_id) {
		
		return trainstaffdao.querytrainbyStaffid(Staff_id);
	}

}
