package com.framgia.fitm.dao;

import java.util.List;

import com.framgia.fitm.model.User;

public interface UserDAO {
	
	public void login(int userId);
	public void logout(int userId);
	public void createUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public void showUser(User user);
	public List<User> Index();

}
