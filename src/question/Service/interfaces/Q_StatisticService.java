package question.Service.interfaces;

import question.domain.Q_Statistic;
import exam.Service.interfaces.CommonService;

public interface Q_StatisticService extends CommonService<Q_Statistic> {

	int getEntryByCondition(int qId, int staffId);

}
