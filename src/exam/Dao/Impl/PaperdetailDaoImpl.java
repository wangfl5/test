package exam.Dao.Impl;

import java.util.List;

import exam.Dao.interfaces.PaperdetailDao;
import exam.domain.Paperdetail;

public class PaperdetailDaoImpl extends CommonDaoImpl<Paperdetail> implements
		PaperdetailDao {

	@Override
	public List<Paperdetail> findSubjects(int pId) {
		List<Paperdetail> list = this.getHibernateTemplate().find("from Paperdetail pd where pd.p_id=? order by pd.p_id asc", pId);
		return list;
	}

	

}
