package train.domain;

import java.io.Serializable;

public class TrainStaff implements Serializable{
	private int trainstaff_id;
	private int train_id;
	private int Staff_id;
	private String Staff_name;
	public int getTrainstaff_id() {
		return trainstaff_id;
	}
	public void setTrainstaff_id(int trainstaffId) {
		trainstaff_id = trainstaffId;
	}
	
	
	public int getTrain_id() {
		return train_id;
	}
	public void setTrain_id(int trainId) {
		train_id = trainId;
	}
	public int getStaff_id() {
		return Staff_id;
	}
	public void setStaff_id(int staffId) {
		Staff_id = staffId;
	}
	public String getStaff_name() {
		return Staff_name;
	}
	public void setStaff_name(String staffName) {
		Staff_name = staffName;
	}
}
