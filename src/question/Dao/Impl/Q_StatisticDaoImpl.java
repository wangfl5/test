package question.Dao.Impl;

import java.util.List;

import question.Dao.interfaces.Q_StatisticDao;
import question.domain.Q_Statistic;
import exam.Dao.Impl.CommonDaoImpl;

public class Q_StatisticDaoImpl extends CommonDaoImpl<Q_Statistic> implements
		Q_StatisticDao {

	@SuppressWarnings("unchecked")
	@Override
	public int getEntryByCondition(int qId, int staffId) {
		List<Q_Statistic> list = this.getHibernateTemplate().find("from Q_Statistic qs where qs.q_id=? and qs.staff_id=?", qId,staffId);
		return list.size();
	}

	

}
