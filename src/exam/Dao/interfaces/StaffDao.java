package exam.Dao.interfaces;

import java.util.List;

import utils.Page;

import exam.domain.Staff;

public interface StaffDao extends CommonDao<Staff>{

	List<Staff> queryStaffBypage(Page page);
	
	
}
