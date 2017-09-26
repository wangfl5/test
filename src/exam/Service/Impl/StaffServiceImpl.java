package exam.Service.Impl;

import java.util.List;

import utils.Page;
import utils.PageResult;
import exam.Dao.interfaces.StaffDao;
import exam.Service.interfaces.StaffService;
import exam.domain.Staff;


public class StaffServiceImpl extends CommonServiceImpl<Staff> implements StaffService {
	
	private StaffDao staffdao;
	
	public StaffDao getStaffdao() {
		return staffdao;
	}

	public void setStaffdao(StaffDao staffdao) {
		this.staffdao = staffdao;
	}

	@Override
	public PageResult queryStaffBypage(Page page) {
		page = utils.PageUtil.createPage(page.getEveryPage(), staffdao.findAllEntry().size(),  page.getCurrentPage());
		List<Staff> list = staffdao.queryStaffBypage(page);
		PageResult pageResult = new PageResult(page, list);
		return pageResult;
	}
	
}
