package exam.Dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import utils.Page;
import utils.PageUtil;

import exam.Dao.interfaces.StaffDao;
import exam.domain.Staff;


public class StaffDaoImpl extends CommonDaoImpl<Staff> implements StaffDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> queryStaffBypage(final Page page) {
		List<Staff> s = (List<Staff>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from Staff s";
				List<Staff> list = (List<Staff>) PageUtil.getList(session, hql, page);
				return list;
			}
		});
		return s;
	}


	
	
	
}
