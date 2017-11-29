package com.framgia.fitm.session;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class SessionHelper {

	public SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

}
