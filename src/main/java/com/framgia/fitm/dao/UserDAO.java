package com.framgia.fitm.dao;

import java.util.List;
import com.framgia.fitm.model.User;

public interface UserDAO extends IGenericDAO<Integer, User> {
    
    public User findByIdLock(Integer Id);
    public List<User> getUserList();
}
