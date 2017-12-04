package com.framgia.fitm.service;

import java.util.List;

import com.framgia.fitm.bean.UserBean;
import com.framgia.fitm.model.User;

public interface UserService {

	public boolean deleteUser(int userId);

	public UserBean showUser(int userId);

	public boolean saveOrupdateUser(User user);

	public List<UserBean> list(Integer offset, Integer maxResult);

	public Long count();
}
