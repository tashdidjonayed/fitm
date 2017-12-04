package com.framgia.fitm.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.framgia.fitm.bean.UserBean;
import com.framgia.fitm.dao.UserDAO;
import com.framgia.fitm.model.User;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	@Override
	@Transactional(readOnly = false)
	public boolean deleteUser(int userId) {
		try {
			User st = userDao.findByIdLock(userId);
			if (st == null)
				return false;

			userDao.delete(st);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public UserBean showUser(int userId) {
		try {
			UserBean userBean = new UserBean();
			BeanUtils.copyProperties(userDao.getFindById(userId), userBean);
			return userBean;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public boolean saveOrupdateUser(User user) {
		try {
			userDao.saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<UserBean> list(Integer offset, Integer maxResult) {
		try {
			List<User> listUsers = userDao.list(offset, maxResult);
			if (listUsers.size() > 0) {
				List<UserBean> listUsersBean = new ArrayList<UserBean>();
				for (User user : listUsers) {
					UserBean userBean = new UserBean();
					BeanUtils.copyProperties(user, userBean);
					listUsersBean.add(userBean);
				}
				return listUsersBean;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public Long count() {
		try {
			return userDao.count();
		} catch (Exception e) {
			return null;
		}
	}
}
