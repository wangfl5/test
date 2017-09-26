package question.Dao.interfaces;

import question.domain.Q_Statistic;
import exam.Dao.interfaces.CommonDao;

public interface Q_StatisticDao extends CommonDao<Q_Statistic> {

	int getEntryByCondition(int qId, int staffId);
	

}
