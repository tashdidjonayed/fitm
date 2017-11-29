package com.framgia.fitm.service;

import java.util.List;

import com.framgia.fitm.model.User;

public interface UserService {
	
	public User login(User p);
	public void logout(int userId);
	public void createUser();
	public void deleteUser(int userId);
	public void updateUser(int userId);
	public void showUser(int userId);
	public List<User> Index();

}
