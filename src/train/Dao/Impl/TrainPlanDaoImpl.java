package train.Dao.Impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import exam.Dao.Impl.CommonDaoImpl;
import train.Dao.interfaces.TrainPlanDao;
import train.domain.TrainPlan;
import utils.Page;
import utils.PageUtil;

public class TrainPlanDaoImpl extends CommonDaoImpl<TrainPlan> implements TrainPlanDao{

	@Override
	public TrainPlan querytrainStaff(String train_title) {
		return (TrainPlan) this.getHibernateTemplate().find("from TrainPlan ts where ts.train_title=?", train_title).get(0);
		
	}

	@Override
	public List<TrainPlan> queryTrainBypage(final Page page) {
		//复杂查询时用executeFind()executeFind()方法需要一个回调HibernateCallback当做参数，
		//HibernateCallback是一个接口，所以还需要实现它的doInHibernate()方法，
		//此方法传递一个Session对象，可以在这个方法中使用Session进行数据的处理
		List<TrainPlan> tp = (List<TrainPlan>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from TrainPlan tp order by tp.train_time desc";
				List<TrainPlan> list = (List<TrainPlan>) PageUtil.getList(session, hql, page);
				return list;
			}
		});
		return tp;
	}


	
	
}
