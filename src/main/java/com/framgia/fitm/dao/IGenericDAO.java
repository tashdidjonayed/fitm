package com.framgia.fitm.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<PK extends Serializable, T> extends java.io.Serializable {
	void delete(T entity);

	void saveOrUpdate(T entity);

	T getFindById(PK key);

	List<T> list(Integer offset, Integer maxResults);

	public Long count();

}
