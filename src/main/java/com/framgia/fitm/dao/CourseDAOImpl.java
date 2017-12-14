package com.framgia.fitm.dao;

import javax.persistence.LockModeType;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.framgia.fitm.model.Course;

@SuppressWarnings("serial")
@Repository
public class CourseDAOImpl extends GenericDAO<Integer, Course> implements CourseDAO {

	public CourseDAOImpl(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);
	}

	@Override
	public Course findByIdLock(Integer Id) {
		return getSession().find(Course.class, Id, LockModeType.PESSIMISTIC_WRITE);
	}
}
