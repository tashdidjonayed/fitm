package com.framgia.fitm.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.framgia.fitm.bean.CourseBean;
import com.framgia.fitm.dao.CourseDAO;
import com.framgia.fitm.model.Course;

@Service("courseService")
@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDAO courseDao;

	@Override
	@Transactional(readOnly = false)
	public boolean deleteCourse(int courseId) {
		try {
			Course course = courseDao.findByIdLock(courseId);
			if (course == null)
				return false;

			courseDao.delete(course);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public CourseBean showCourse(int courseId) {
		try {
			CourseBean courseBean = new CourseBean();
			BeanUtils.copyProperties(courseDao.getFindById(courseId), courseBean);
			return courseBean;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public boolean saveOrupdateCourse(Course course) {
		try {
			courseDao.saveOrUpdate(course);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<CourseBean> list(Integer offset, Integer maxResults) {
		try {
			List<Course> listCourses = courseDao.list(offset, maxResults);
			if (listCourses.size() > 0) {
				List<CourseBean> listCoursesBean = new ArrayList<CourseBean>();
				for (Course course : listCourses) {
					CourseBean courseBean = new CourseBean();
					BeanUtils.copyProperties(course, courseBean);
					listCoursesBean.add(courseBean);
				}
				return listCoursesBean;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public Long count() {
		try {
			return courseDao.count();
		} catch (Exception e) {
			return null;
		}
	}
}
