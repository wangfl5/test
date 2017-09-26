package exam.Dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import utils.Page;
import utils.PageUtil;
import exam.Dao.interfaces.SubjectDao;
import exam.domain.Subject;

public class SubjectDaoImpl extends CommonDaoImpl<Subject> implements SubjectDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> querySubjectBypage(final Page page) {
		List<Subject> s = (List<Subject>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from Subject s";
				List<Subject> list = (List<Subject>) PageUtil.getList(session, hql, page);
				return list;
			}
		});
		return s;
	}

	
}
