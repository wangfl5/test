package exam.Dao.Impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import question.domain.Question;

import utils.Page;
import utils.PageUtil;
import exam.Dao.interfaces.PaperDao;
import exam.domain.Paper;


public class PaperDaoImpl extends CommonDaoImpl<Paper> implements PaperDao {

	@SuppressWarnings("unchecked")
	public List<Paper> queryPaperBypage(final Page page,final String examName,final Date examStart,final Date examEnd) {
		List<Paper> p = (List<Paper>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer sb = new StringBuffer();
				sb.append("from Paper where 1=1");
				if(StringUtils.isNotEmpty(examName)){
					sb.append(" and p_name ='"+examName+"'");
				}
				if(!(examStart==null)){
					sb.append(" and p_time >:examStart");
					sb.append(" and p_time <:examEnd");
				}
			
				String hql = sb.toString();
				Query query = session.createQuery(hql);
				if(!(examStart==null)){
					query.setParameter("examStart", examStart);
					query.setParameter("examEnd", examEnd);
				}
				query.setMaxResults(page.getEveryPage()).setFirstResult(page.getBeginIndex());
				List<Paper> list = query.list();
				return list;
			}
		});
		return p;
	}

	@Override
	public List<Paper> queryPaperBycondition(String examName, Date examStart,
			Date examEnd) {
		StringBuffer sb = new StringBuffer();
		sb.append("from Paper where 1=1");
		if(StringUtils.isNotEmpty(examName)){
			sb.append(" and p_name = '"+examName+"'");
		}
		//按时间条件动态查询
		if(!(examStart==null)){
			sb.append(" and p_time >?");
			sb.append(" and p_time <?");	
			List<Paper> paper = this.getHibernateTemplate().find(sb.toString(),examStart,examEnd);
			return paper;
		}
		List<Paper> paper = this.getHibernateTemplate().find(sb.toString());
		
		return paper;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paper> findQuestionbyDate(Date date) {
		List<Paper> list = this.getHibernateTemplate().find("from Paper p where p.p_time > ?", date);
		return list;
	}


}
