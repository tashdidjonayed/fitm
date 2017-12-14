package com.framgia.fitm.dao;

import com.framgia.fitm.model.Course;

public interface CourseDAO extends IGenericDAO<Integer, Course> {

	public Course findByIdLock(Integer Id);
}
