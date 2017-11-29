package com.framgia.fitm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.framgia.fitm.dao.UserDAO;
import com.framgia.fitm.model.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDao;

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public User login(User p) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void logout(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void createUser() {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void updateUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void showUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public List<User> Index() {
		return null;
		// TODO Auto-generated method stub

	}

}
