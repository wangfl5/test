package exam.Service.Impl;

import java.io.Serializable;
import java.util.List;

import exam.Dao.interfaces.CommonDao;
import exam.Service.interfaces.CommonService;

public class CommonServiceImpl<T> implements CommonService<T>{
	private CommonDao commonDao;

	public CommonDao getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	@Override
	public List<T> findAllEntry() {
		// TODO Auto-generated method stub
		return this.commonDao.findAllEntry();
	}

	@Override
	public void saveEntry(T t) {
		// TODO Auto-generated method stub
		this.commonDao.saveEntry(t);
	}

	@Override
	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		this.commonDao.updateEntry(t);
	}

	@Override
	public void deleteEntry(Serializable id) {
		// TODO Auto-generated method stub
		this.commonDao.deleteEntry(id);
	}

	@Override
	public T getEntryByID(Serializable id) {
		// TODO Auto-generated method stub
		return (T)this.commonDao.getEntryByID(id);
	}
	
}
