package question.Service.Impl;

import question.Dao.interfaces.Q_StatisticDao;
import question.Service.interfaces.Q_StatisticService;
import question.domain.Q_Statistic;
import exam.Service.Impl.CommonServiceImpl;

public class Q_StatisticServiceImpl extends CommonServiceImpl<Q_Statistic>
		implements Q_StatisticService {
	private Q_StatisticDao q_statisticdao;
	
	public Q_StatisticDao getQ_statisticdao() {
		return q_statisticdao;
	}

	public void setQ_statisticdao(Q_StatisticDao qStatisticdao) {
		q_statisticdao = qStatisticdao;
	}

	@Override
	public int getEntryByCondition(int qId, int staffId) {
		
		return q_statisticdao.getEntryByCondition(qId,staffId);
	}


}
