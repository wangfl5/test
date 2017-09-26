package train.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class TrainPlan implements Serializable{
	private int train_id;
	private String train_title;
	private Date train_time;
	private String train_place;
	private String state;
	private String file;
	private int set_id;
	private Set<TrainStaff> trainstaff;
	public Set<TrainStaff> getTrainstaff() {
		return trainstaff;
	}
	public void setTrainstaff(Set<TrainStaff> trainstaff) {
		this.trainstaff = trainstaff;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public int getSet_id() {
		return set_id;
	}
	public void setSet_id(int setId) {
		set_id = setId;
	}
	
}
