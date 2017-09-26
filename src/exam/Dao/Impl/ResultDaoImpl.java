package exam.Dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import utils.Page;
import utils.PageUtil;

import exam.Dao.interfaces.ResultDao;
import exam.domain.Result;
import exam.domain.Subject;

public class ResultDaoImpl extends CommonDaoImpl<Result> implements ResultDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Result> findbystaffId(int staffId) {
		List<Result> list = this.getHibernateTemplate().find("from Result r where r.staff_id=?", staffId);
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Result> queryResultBypage(final Page page) {
		List<Result> r = (List<Result>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from Result r";
				List<Result> list = (List<Result>) PageUtil.getList(session, hql, page);
				return list;
			}
		});
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Result> findByPaper(int pId) {
		List<Result> list = this.getHibernateTemplate().find("from Result r where r.p_id=?", pId);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getEntryByCondition(int pId, int staffId) {
		List<Result> list = this.getHibernateTemplate().find("from Result r where r.p_id=? and r.staff_id=?", pId,staffId);
		return list.size();
	}

}
