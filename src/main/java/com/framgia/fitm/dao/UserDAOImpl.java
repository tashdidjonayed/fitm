package com.framgia.fitm.dao;

import java.util.List;

import javax.persistence.LockModeType;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.framgia.fitm.model.User;

@SuppressWarnings("serial")
@Repository("userDAO")
public class UserDAOImpl extends GenericDAO<Integer, User> implements UserDAO {

    public UserDAOImpl(SessionFactory sessionfactory) {
	setSessionFactory(sessionfactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUserList() {
	return getSession().createQuery("from User").getResultList();
    }

    @Override
    public User findByIdLock(Integer Id) {
	return getSession().find(User.class, Id, LockModeType.PESSIMISTIC_WRITE);
    }
}
