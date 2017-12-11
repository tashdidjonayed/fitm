package com.framgia.fitm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public User showUser(int userId) {
	try {
	    return userDao.getFindById(userId);
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
    public List<User> getUserList() {
	try {
	    return userDao.getUserList();
	} catch (Exception e) {
	    return null;
	}
    }
}
