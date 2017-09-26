package exam.Service.interfaces;

import utils.Page;
import utils.PageResult;
import exam.domain.Staff;


public interface StaffService extends CommonService<Staff>{

	PageResult queryStaffBypage(Page page);
	
}
