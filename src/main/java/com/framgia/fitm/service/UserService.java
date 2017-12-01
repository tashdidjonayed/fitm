package com.framgia.fitm.service;

import java.util.List;
import com.framgia.fitm.model.User;

public interface UserService {

    public boolean deleteUser(int userId);

    public User showUser(int userId);

    public boolean saveOrupdateUser(User user);

    public List<User> getUserList();
}
