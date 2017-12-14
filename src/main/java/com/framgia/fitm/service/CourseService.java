package com.framgia.fitm.service;

import java.util.List;
import com.framgia.fitm.bean.CourseBean;
import com.framgia.fitm.model.Course;

public interface CourseService {
	public boolean deleteCourse(int courseId);

	public CourseBean showCourse(int courseId);

	public boolean saveOrupdateCourse(Course course);

	public List<CourseBean> list(Integer offset, Integer maxResults);

	public Long count();
}
