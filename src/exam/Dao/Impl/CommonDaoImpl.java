package exam.Dao.Impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import exam.Dao.interfaces.CommonDao;

public class CommonDaoImpl<T> implements CommonDao<T>{
	private Class classt;
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public CommonDaoImpl(){
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.classt = (Class)type.getActualTypeArguments()[0];
	}

	@Override
	public List<T> findAllEntry() {
		
		return this.hibernateTemplate.find("from "+this.classt.getName());
	}

	@Override
	public void saveEntry(T t) {
		
		this.hibernateTemplate.save(t);
	}

	@Override
	public void updateEntry(T t) {
		
		this.hibernateTemplate.update(t);
	}

	@Override
	public void deleteEntry(Serializable id) {
		
		T t = (T)this.hibernateTemplate.get(this.classt, id);
		this.hibernateTemplate.delete(t);
	}

	@Override
	public T getEntryByID(Serializable id) {
		
		return (T)this.hibernateTemplate.get(this.classt, id);
	}
	
}
