package com.framgia.fitm.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.framgia.fitm.util.Constants;

public abstract class GenericDAO<PK extends Serializable, T> extends HibernateDaoSupport {

	@Autowired
	private SessionFactory sessionFactory;

	public T getFindById(PK key) {
		return (T) getSession().get(getPersistentClass(), key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	private Class<T> persistentClass;

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public GenericDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<T> list(Integer offset, Integer maxResults) {
		return getSession().createCriteria(getPersistentClass()).setFirstResult(offset != null ? offset : 0)
				.setMaxResults(maxResults != null ? maxResults : Constants.MAX).list();
	}

	public Long count() {
		return (Long) getSession().createCriteria(this.getPersistentClass()).setProjection(Projections.rowCount())
				.uniqueResult();
	}
}
