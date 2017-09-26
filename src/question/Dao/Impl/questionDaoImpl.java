package question.Dao.Impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import question.Dao.interfaces.questionDao;
import question.domain.Question;
import utils.Page;
import utils.PageUtil;
import exam.Dao.Impl.CommonDaoImpl;
import exam.domain.Subject;

/**
 * @author Home
 *
 */
public class questionDaoImpl extends CommonDaoImpl<Question> implements
		questionDao {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllEntry() {
		return this.getHibernateTemplate().find("from  Question q order by q.q_id desc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findQuestionbyDate(Date date) {
		List<Question> list = this.getHibernateTemplate().find("from Question q where q.q_endtime > ?", date);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> queryQuestionBypage(final Page page) {
		List<Question> q = (List<Question>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from Question q order by q.q_endtime desc";
				List<Question> list = (List<Question>) PageUtil.getList(session, hql, page);
				return list;
			}
		});
		return q;
	}

	

}
